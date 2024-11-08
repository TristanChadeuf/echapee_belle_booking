package com.echappeebelle.booking.model;


public class BookingUserVehicleCheck {

    private int userId;
    private int vehicleId;

    public BookingUserVehicleCheck( int userId, int vehicleId ) {

    }

    //GETTER SETTER *************************************************************
    public int getUserId() {
        return userId;
    }
    public void setUserId( int userId ) {
        this.userId = userId;
    }
    public int getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId( int vehicleId ) {
        this.vehicleId = vehicleId;
    }
}
