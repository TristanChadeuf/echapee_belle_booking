package com.echappeebelle.booking.dao;


import com.echappeebelle.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking, Integer> {


}
