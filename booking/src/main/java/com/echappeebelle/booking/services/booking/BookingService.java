package com.echappeebelle.booking.services.booking;

import com.echappeebelle.booking.model.Booking;
import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking>findAll();
    Optional<Booking> findById(int id);
    Booking save(Booking vehicle);
    Booking update(int id, Booking vehicle);
    void deleteById(int id);
    void deleteAll();
}
