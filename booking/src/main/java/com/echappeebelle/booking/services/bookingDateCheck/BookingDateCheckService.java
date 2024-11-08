package com.echappeebelle.booking.services.bookingDateCheck;

import com.echappeebelle.booking.model.BookingDateCheck;
import com.echappeebelle.booking.model.Vehicle;

import java.util.List;

public interface BookingDateCheckService {

    boolean checkBookingDate(BookingDateCheck bookingDateCheck);

    List<Vehicle> getAvailableVehicles(BookingDateCheck bookingDateCheck);

}
