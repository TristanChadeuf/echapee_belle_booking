package com.echappeebelle.booking.web.controller;

import com.echappeebelle.booking.dao.BookingDao;
import com.echappeebelle.booking.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    //CONSTRUCTOR*******************************************************************************************************
    private final BookingDao bookingDao;
    @Autowired

    public BookingController(BookingDao bookingDao) {
        this.bookingDao= bookingDao;
    }

    //ROUTE ALL BOOKING*************************************************************************************************
    @GetMapping("/booking")
    public List<Booking> AllBookings() {
        return bookingDao.findAll();
    }

    //ROUTE BOOKING ID**************************************************************************************************

    @GetMapping(value = "/booking/{id}")
    public Booking afficherUneReservation(@PathVariable int id) {
        return bookingDao.findById(id).orElse(null);
    }

    //ROUTE CREATE BOOKING**********************************************************************************************
    @PostMapping(value="/booking/{id}")
    public Booking ajouterUneReservation(@RequestBody Booking booking, @PathVariable int id) {
                booking.setId(id);
                return bookingDao.save(booking);
    }
    //ROUTE UPDATE BOOKING**********************************************************************************************
    @PutMapping(value = "/booking/{id}")
    public Booking modifierUneReservation(@PathVariable int id , @RequestBody Booking booking) {
        booking.setId(id);
        return bookingDao.save(booking);
    }

    //ROUTE DELETE BOOKING**********************************************************************************************
    @DeleteMapping(value = "/booking/{id}")
    public void supprimerUneRservation(@PathVariable int id) {
        bookingDao.deleteById(id);
    }
}
