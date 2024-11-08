package com.echappeebelle.booking.web.controller;

import com.echappeebelle.booking.model.Booking;
import com.echappeebelle.booking.model.BookingDateCheck;
import com.echappeebelle.booking.model.Vehicle;
import com.echappeebelle.booking.services.booking.BookingService;
import com.echappeebelle.booking.services.bookingDateCheck.BookingDateCheckService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingDateCheckController  {

    private final BookingDateCheckService bookingDateCheckService;

    //CONSTRUCTOR*************************************************************
    public BookingDateCheckController( BookingDateCheckService bookingDateCheckService) {
        this.bookingDateCheckService =  bookingDateCheckService;
    }

    @PostMapping("/booking-date-check")
    public boolean checkBookingDate(@RequestBody BookingDateCheck bookingDateCheck) {
        return bookingDateCheckService.checkBookingDate(bookingDateCheck);
    }

    @PostMapping("/booking/vehicle")
    public List<Vehicle> allVehiclesAvailable(@RequestBody BookingDateCheck bookingDateCheck){
        return bookingDateCheckService.getAvailableVehicles(bookingDateCheck);
    }

}

