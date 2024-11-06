package com.echappeebelle.booking.services.bookingDateCheck;

import com.echappeebelle.booking.model.BookingDateCheck;

import java.time.LocalDate;

public interface BookingDateCheckService {

    boolean checkBookingDate(BookingDateCheck bookingDateCheck);


}
