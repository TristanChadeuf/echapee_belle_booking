package com.echappeebelle.booking.services.bookingUserVehicleCheck;

import com.echappeebelle.booking.dao.BookingDao;
import com.echappeebelle.booking.model.Booking;
import com.echappeebelle.booking.model.BookingUserVehicleCheck;
import com.netflix.discovery.EurekaClient;

import java.util.List;

public class BookingUserVehicleCheckServiceImpl implements BookingUserVehicleCheckService {

    private final EurekaClient eurekaClient;
    private final BookingDao bookingDao;

    public BookingUserVehicleCheckServiceImpl(EurekaClient eurekaClient, BookingDao bookingDao) {
        this.eurekaClient = eurekaClient;
        this.bookingDao = bookingDao;
    }


    public boolean checkUserVehicle(BookingUserVehicleCheck bookingUserVehicleCheck) {
        List<Booking> BookingList = bookingDao.findByVehicleId(bookingUserVehicleCheck.getVehicleId());

        boolean userHaveAlreadyVehicle= true;

        int userId = bookingUserVehicleCheck.getUserId();
        int vehicleId = bookingUserVehicleCheck.getVehicleId();
        for (Booking booking : BookingList) {
            if (booking.getUserId() == userId && booking.getVehicleId() == vehicleId) {
                userHaveAlreadyVehicle = false;
                break;
            }
            return userHaveAlreadyVehicle;
        }
        return userHaveAlreadyVehicle;
    }
}
