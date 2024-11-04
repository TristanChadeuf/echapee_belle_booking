package com.echappeebelle.booking.model;
import jakarta.persistence.*;

import java.time.LocalDate;

//@JsonFilter("monFiltreDynamique")
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private int booking_number;
    private LocalDate start_date;
    private LocalDate end_date;
    private int vehicle_id;
    private int user_id;


    public Booking(int id,
                   int booking_number,
                   LocalDate start_date,
                   LocalDate end_date,
                   int vehicle_id,
                   int user_id) {


        this.id = id;
        this.booking_number = booking_number;
        this.start_date = start_date;
        this.end_date = end_date;
        this.vehicle_id = vehicle_id;
        this.user_id = user_id;

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
    //GETTER SETTER BOOKING NUMBER**************************************************************************************
    public int getBooking_number() {
        return this.booking_number;
    }
    public void setBooking_number(int booking_number) {
        this.booking_number = booking_number;
    // GETTER SETTER START DATE*****************************************************************************************
    }
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

}