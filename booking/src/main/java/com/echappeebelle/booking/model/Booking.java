package com.echappeebelle.booking.model;

import jakarta.persistence.*;


import java.time.LocalDate;

//@JsonFilter("monFiltreDynamique")
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate startDate;
    private LocalDate endDate;
    private int vehicleId;
    private int userId;
    private int numberKm;


    public Booking(int id,

                   LocalDate start_date,
                   LocalDate end_date,
                   int vehicle_id,
                   int user_id,
                   int numberKm) {


        this.id = id;
        this.startDate = start_date;
        this.endDate = end_date;
        this.vehicleId = vehicle_id;
        this.userId = user_id;
        this.numberKm = numberKm;

    }

    public Booking() {

    }

//GETTER SETTER*********************************************************************************************************

    //GETTER SETTER ID******************************************************************************************************
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // GETTER SETTER START DATE*****************************************************************************************

    public LocalDate getStartDate() {
        return this.startDate;

    }

    public void setStartDate(LocalDate start_date) {
        this.startDate = start_date;
        // GETTER SETTER END DATE ******************************************************************************************
    }

    public LocalDate getEndDate() {
        return this.endDate;

    }

    public void setEndDate(LocalDate end_date) {

        this.endDate = end_date;

    }

    // ID VEHICLE*******************************************************************************************************
    public int getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    //ID USER***********************************************************************************************************
    public int getUserId() {
        return this.userId;

    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    //GETTER SETTER NUMBER KM*******************************************************************************************
    public int getNumberKm() {
        return this.numberKm;
    }

    public void setNumberKm(int numberKm) {
        this.numberKm = numberKm;
    }
}