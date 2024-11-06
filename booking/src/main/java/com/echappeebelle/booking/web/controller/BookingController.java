package com.echappeebelle.booking.web.controller;

import com.echappeebelle.booking.model.Booking;
import com.echappeebelle.booking.services.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    //CONSTRUCTOR*******************************************************************************************************
    private final BookingService bookingService;
    @Autowired

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    //ROUTE ALL BOOKING*************************************************************************************************
    @GetMapping("/booking")
    public List<Booking> AllBookings() {
        return bookingService.findAll();
    }

    //ROUTE BOOKING ID**************************************************************************************************

    @GetMapping(value = "/booking/{id}")
    public Booking afficherUneReservation(@PathVariable int id) {
        return bookingService.findById(id).orElse(null);
    }

    //ROUTE CREATE BOOKING**********************************************************************************************
    @PostMapping(value="/booking")
    public Booking ajouterUneReservation(@RequestBody Booking booking){
                return bookingService.save(booking);
    }
    //ROUTE UPDATE BOOKING**********************************************************************************************
    @PutMapping(value = "/booking/{id}")
    public Booking modifierUneReservation(@PathVariable int id , @RequestBody Booking booking) {
        booking.setId(id);
        return bookingService.update(id, booking);
    }

    //ROUTE DELETE BOOKING**********************************************************************************************
    @DeleteMapping(value = "/booking/{id}")
    public void supprimerUneRservation(@PathVariable int id) {
        bookingService.deleteById(id);
    }
    @DeleteMapping(value = "/booking")
    public void supprimerTouteReservation() {
        bookingService.deleteAll();
    }
}
