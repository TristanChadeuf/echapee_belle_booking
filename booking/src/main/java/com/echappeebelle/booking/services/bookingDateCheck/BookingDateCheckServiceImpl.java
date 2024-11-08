package com.echappeebelle.booking.services.bookingDateCheck;

import com.echappeebelle.booking.dao.BookingDao;
import com.echappeebelle.booking.model.Booking;
import com.echappeebelle.booking.model.BookingDateCheck;
import com.echappeebelle.booking.model.Vehicle;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookingDateCheckServiceImpl implements BookingDateCheckService {

    private final EurekaClient eurekaClient;
    private final BookingDao bookingDao;

    public BookingDateCheckServiceImpl(EurekaClient eurekaClient, BookingDao bookingDao) {
        this.eurekaClient = eurekaClient;
        this.bookingDao = bookingDao;
    }


    public boolean checkBookingDate(BookingDateCheck bookingDateCheck) {

    List<Booking> BookingList  = bookingDao.findByVehicleId(bookingDateCheck.getIdVehicle());

        LocalDate startUser = bookingDateCheck.getStartDate();
        LocalDate endUser = bookingDateCheck.getEndDate();

    boolean isAvailable = true;
    for (Booking booking : BookingList) {

        LocalDate startBooking = booking.getStartDate();
        LocalDate endBooking = booking.getEndDate();

        if(startUser.isBefore(startBooking) && endUser.isAfter(endBooking)) {
            isAvailable = false;
            System.out.println("startUser.isBefore(startBooking) && endUser.isAfter(endBooking)");
            break;
        }else if (startUser.isAfter(startBooking) && endUser.isBefore(endBooking)) {
            isAvailable = false;
            System.out.println("startUser.isAfter(startBooking) && endUser.isBefore(endBooking)");
            break;
        }else if (startUser.isEqual(startBooking) || endUser.isEqual(endBooking) || startUser.equals(endBooking) || endUser.equals(startBooking)) {
            isAvailable = false;
            System.out.println("startUser.isEqual(startBooking) || endUser.isEqual(endBooking) || startUser.equals(endBooking) || endUser.equals(startBooking)");
            break;
        }else if (startUser.isBefore(startBooking) && endUser.isAfter(startBooking)) {
            isAvailable = false;
            System.out.println("startUser.isBefore(startBooking) && endUser.isAfter(startBooking)");
            break;
        }else if (startUser.isBefore(endBooking) && endUser.isAfter(endBooking)) {
            isAvailable = false;
            System.out.println("startUser.isBefore(endBooking) && endUser.isAfter(endBooking)");
            break;
        }
    }
    return isAvailable;
    }


    public List<Vehicle> getAvailableVehicles(BookingDateCheck bookingDateCheck) {
        List<Integer> listVehicleAvailable = new ArrayList<>();
        List<Booking> BookingList = bookingDao.findAll();

        LocalDate startUser = bookingDateCheck.getStartDate();
        LocalDate endUser = bookingDateCheck.getEndDate();

        for (Booking booking : BookingList) {
            LocalDate startBooking = booking.getStartDate();
            LocalDate endBooking = booking.getEndDate();

            if(startUser.isBefore(startBooking) && endUser.isAfter(endBooking)) {
                listVehicleAvailable.add(booking.getVehicleId());
            }else if (startUser.isAfter(startBooking) && endUser.isBefore(endBooking)) {
                listVehicleAvailable.add(booking.getVehicleId());
            }else if (startUser.isEqual(startBooking) || endUser.isEqual(endBooking) || startUser.equals(endBooking) || endUser.equals(startBooking)) {
                listVehicleAvailable.add(booking.getVehicleId());
            }else if (startUser.isBefore(startBooking) && endUser.isAfter(startBooking)) {
                listVehicleAvailable.add(booking.getVehicleId());
            }else if (startUser.isBefore(endBooking) && endUser.isAfter(endBooking)) {
                listVehicleAvailable.add(booking.getVehicleId());
            }
        }
        List<Vehicle> vehicles = List.of();
        try {

            RestTemplate restTemplate = new RestTemplate();
            Application applicationVehicle = eurekaClient.getApplication("ECHAPPEEBELLEVEHICLE");

            InstanceInfo instanceInfoVehicle = applicationVehicle.getInstances().get(0); // Get the first instance (or handle multiple)
            String baseUrlVehicle = instanceInfoVehicle.getHomePageUrl();

            ResponseEntity<List<Vehicle>> vehicleResponse = restTemplate.exchange(
                    baseUrlVehicle + "vehicles",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Vehicle>>() {
                    }
            );
             vehicles = vehicleResponse.getBody();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Iterator<Vehicle> iterator = vehicles.iterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = iterator.next();
            if (listVehicleAvailable.contains(vehicle.getIdVehicle())) {
                iterator.remove();
            }
        }

        return vehicles;

    }
}
