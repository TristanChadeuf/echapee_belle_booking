package com.echappeebelle.booking.services;


import com.echappeebelle.booking.dao.BookingDao;
import com.echappeebelle.booking.model.Booking;
import com.echappeebelle.booking.model.User;
import com.echappeebelle.booking.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service

public class BookingServiceImpl implements BookingService {

    private final BookingDao bookingDao;

    @Autowired
    public BookingServiceImpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public List<Booking> findAll() {
        return bookingDao.findAll();
    }

    public Optional<Booking> findById(int id) {
        return bookingDao.findById(id);
    }


    public Booking save(Booking booking) {


        try {

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<User> userResponse = restTemplate.getForEntity("http://localhost:9090/user/" + booking.getUser_id(), User.class);

            ResponseEntity<Vehicle> vehicleResponse = restTemplate.getForEntity("http://localhost:8080/vehicles/" + booking.getVehicle_id(), Vehicle.class);


            User user = userResponse.getBody();
            Vehicle vehicle = vehicleResponse.getBody();

            if (user.getAge() < 18) {
                throw new Exception("Vous devez avoir minimum 18ans");
            } else if (user.getAge() < 21 && vehicle.getTaxHorses() >= 8) {
                throw new Exception("Vous devez avoir minimum 21 ans pour ce véhicule de 8 chevaux fiscaux");
            } else if (user.getAge() < 25 && vehicle.getTaxHorses() >= 13) {
                throw new Exception("Vous devez avoir minimum 25 ans pour ce véhicule de 13 chevaux fiscaux");
            } else {
                return bookingDao.save(booking);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Booking BlockDate(Booking booking) {



        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Vehicle> vehicleResponse = restTemplate.getForEntity("http://192.168.1.245:8080/vehicles/" + booking.getVehicle_id(), Vehicle.class);
        ResponseEntity<Booking> bookingResponse = restTemplate.getForEntity("http://localhost:8081/booking/" + booking.getId(), Booking.class);



        return booking;

    }

    public Booking update(int id, Booking newBooking) {
        Optional<Booking> optionalBooking = bookingDao.findById(id);

        if (optionalBooking.isPresent()) {
            Booking existingBooking = optionalBooking.get();

            existingBooking.setUser_id(newBooking.getUser_id());
            existingBooking.setVehicle_id(newBooking.getVehicle_id());
            existingBooking.setStart_date(newBooking.getStart_date());
            existingBooking.setEnd_date(newBooking.getEnd_date());
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

    @Override
    public void deleteAll() {
        bookingDao.deleteAll();
    }
}
