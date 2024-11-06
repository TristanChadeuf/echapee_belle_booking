package com.echappeebelle.booking.web.controller;

import com.echappeebelle.booking.model.BookingDateCheck;
import com.echappeebelle.booking.services.booking.BookingService;
import com.echappeebelle.booking.services.bookingDateCheck.BookingDateCheckService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingDateCheckController  {

    private BookingDateCheckService bookingDateCheckService;

    //CONSTRUCTOR*************************************************************
    public BookingDateCheckController( BookingDateCheckService bookingDateCheckService) {
        this.bookingDateCheckService =  bookingDateCheckService;
    }

    @PostMapping("/booking-date-check")
    public Boolean checkBookingDate(@RequestBody BookingDateCheck bookingDateCheck) {
        return bookingDateCheckService.checkBookingDate(bookingDateCheck);
    }

}
