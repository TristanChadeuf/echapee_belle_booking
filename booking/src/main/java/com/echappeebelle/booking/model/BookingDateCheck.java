package com.echappeebelle.booking.model;

import java.time.LocalDate;

public class BookingDateCheck {


    private LocalDate startDate;
    private LocalDate endDate;
    private int idVehicle;

    public BookingDateCheck() {}

    public BookingDateCheck(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BookingDateCheck(LocalDate startDate, LocalDate endDate, int idVehicle ) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.idVehicle = idVehicle;
    }



    //GETTER SETTER*****************************************************************************************************
    public LocalDate getStartDate() {
        return startDate;

    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getIdVehicle() {
        return idVehicle;
    }
    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

}
