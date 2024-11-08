package com.echappeebelle.booking.dao;


import com.echappeebelle.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingDao extends JpaRepository<Booking, Integer> {

    public List<Booking> findByVehicleId(int idVehicle);

}
