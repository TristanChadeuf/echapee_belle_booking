package com.echappeebelle.booking.services.booking;


import com.echappeebelle.booking.dao.BookingDao;
import com.echappeebelle.booking.model.Booking;
import com.echappeebelle.booking.model.User;
import com.echappeebelle.booking.model.Vehicle;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;


@Service

public class BookingServiceImpl implements BookingService {
    @Value("${server.port}")
    private int port;
    private final EurekaClient eurekaClient;
    private final BookingDao bookingDao;

    @Autowired
    public BookingServiceImpl(EurekaClient eurekaClient, BookingDao bookingDao) {
        this.eurekaClient = eurekaClient;
        this.bookingDao = bookingDao;
    }


    public Booking save(Booking booking) {

        try {

            RestTemplate restTemplate = new RestTemplate();
            Application applicationVehicle = eurekaClient.getApplication("ECHAPPEEBELLEVEHICLE");
            Application applicationUser = eurekaClient.getApplication("USERS");
            Application applicationBooking = eurekaClient.getApplication("BOOKING");

            InstanceInfo instanceInfoVehicle = applicationVehicle.getInstances().get(0); // Get the first instance (or handle multiple)
            String baseUrlVehicle = instanceInfoVehicle.getHomePageUrl();
            InstanceInfo instanceInfoUser = applicationUser.getInstances().get(0); // Get the first instance (or handle multiple)
            String baseUrlUser = instanceInfoUser.getHomePageUrl();
            InstanceInfo instanceInfoBooking = applicationBooking.getInstances().get(0); // Get the first instance (or handle multiple)
            String baseUrlBooking = instanceInfoBooking.getHomePageUrl();


            List<Booking> bookings = List.of();

            ResponseEntity<User> userResponse = restTemplate.getForEntity(baseUrlUser + "user/" + booking.getUserId(), User.class);
            ResponseEntity<Vehicle> vehicleResponse = restTemplate.getForEntity(baseUrlVehicle + "vehicles/" + booking.getVehicleId(), Vehicle.class);
            ResponseEntity<List<Booking>> bookingResponse = restTemplate.exchange(
                    baseUrlBooking + "booking",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Booking>>() {
                    }
            );


            bookings = bookingResponse.getBody();

            assert bookings != null;
            if (!bookings.isEmpty()) {
                bookings.removeIf(booking1 -> booking1.getUserId() != booking.getUserId());


                LocalDate startUser = booking.getStartDate();
                LocalDate endUser = booking.getEndDate();

                for (Booking booking1 : bookings) {

                    LocalDate startBooking = booking1.getStartDate();
                    LocalDate endBooking = booking1.getEndDate();

                    if (startUser.isBefore(startBooking) && endUser.isAfter(endBooking)) {
                        throw new Exception("Vous ne pouvez pas réserver plusieur véhicules simultanéments");
                    } else if (startUser.isAfter(startBooking) && endUser.isBefore(endBooking)) {
                        throw new Exception("Vous ne pouvez pas réserver plusieur véhicules simultanéments");
                    } else if (startUser.isEqual(startBooking) || endUser.isEqual(endBooking) || startUser.equals(endBooking) || endUser.equals(startBooking)) {
                        throw new Exception("Vous ne pouvez pas réserver plusieur véhicules simultanéments");
                    } else if (startUser.isBefore(startBooking) && endUser.isAfter(startBooking)) {
                        throw new Exception("Vous ne pouvez pas réserver plusieur véhicules simultanéments");
                    } else if (startUser.isBefore(endBooking) && endUser.isAfter(endBooking)) {
                        throw new Exception("Vous ne pouvez pas réserver plusieur véhicules simultanéments");
                    }
                }
            }

            User user = userResponse.getBody();
            Vehicle vehicle = vehicleResponse.getBody();


            assert user != null;
            return checkAge(user, vehicle, booking);


        } catch (Exception e) {

            System.out.println(e.getMessage());

            return null;
        }
    }

    public List<Booking> findAll() {
        return bookingDao.findAll();
    }

    public Optional<Booking> findById(int id) {
        return bookingDao.findById(id);
    }


    public Booking update(int id, Booking newBooking) {
        Optional<Booking> optionalBooking = bookingDao.findById(id);

        if (optionalBooking.isPresent()) {
            Booking existingBooking = optionalBooking.get();

            existingBooking.setUserId(newBooking.getUserId());
            existingBooking.setVehicleId(newBooking.getVehicleId());
            existingBooking.setStartDate(newBooking.getStartDate());
            existingBooking.setEndDate(newBooking.getEndDate());
            existingBooking.setNumberKm(newBooking.getNumberKm());

            newBooking = bookingDao.save(existingBooking);

            return newBooking;
        }
        return null;
    }

    public void deleteById(int id) {
        if (bookingDao.existsById(id)) {
            bookingDao.deleteById(id);
        } else {
            throw new RuntimeException("Booking not found with id: " + id);
        }
    }

    public void deleteAll() {
        bookingDao.deleteAll();
    }


    private Booking checkAge(User user, Vehicle vehicle, Booking booking) throws Exception {
        if (user.getAge() < 18) {
            throw new Exception("Vous devez avoir minimum 18ans");
        } else if (user.getAge() < 21 && vehicle.getTaxHorses() >= 8) {
            throw new Exception("Vous devez avoir minimum 21 ans pour ce véhicule de 8 chevaux fiscaux");
        } else if (user.getAge() < 25 && vehicle.getTaxHorses() >= 13) {
            throw new Exception("Vous devez avoir minimum 25 ans pour ce véhicule de 13 chevaux fiscaux");
        } else {
            return bookingDao.save(booking);
        }
    }
}