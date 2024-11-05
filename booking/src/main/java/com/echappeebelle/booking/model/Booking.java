package com.echappeebelle.booking.model;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//@JsonFilter("monFiltreDynamique")
@Entity
public class Booking {

    @Id
    private int id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate start_date;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate end_date;
    private int vehicle_id;
    private int user_id;
    private int numberKm;


    public Booking(int id,

                   LocalDate start_date,
                   LocalDate end_date,
                   int vehicle_id,
                   int user_id,
                    int numberKm) {


        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.vehicle_id = vehicle_id;
        this.user_id = user_id;
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

    public LocalDate getStart_date() {
        return this.start_date;

    }
    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    // GETTER SETTER END DATE ******************************************************************************************
    }
    public LocalDate getEnd_date() {
        return this.end_date;

    }
    public void setEnd_date(LocalDate end_date) {

        this.end_date = end_date;

    }
    // ID VEHICLE*******************************************************************************************************
    public int getVehicle_id() {
        return this.vehicle_id;
    }
    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }
    //ID USER***********************************************************************************************************
    public int getUser_id() {
        return this.user_id;

    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    //GETTER SETTER NUMBER KM*******************************************************************************************
    public int getNumberKm() {
        return this.numberKm;
    }
    public void setNumberKm(int numberKm) {
        this.numberKm = numberKm;
    }
}