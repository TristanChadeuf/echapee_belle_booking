package com.echappeebelle.booking.model;

public class Vehicle{

    private int idVehicle;
    private int bookingPriceInCents;
    private int pricePerKilometerInCents;
    private int taxHorses;


    public Vehicle() {
    }

    // Constructor to initialize all properties when creating a new Vehicle instance.
    public Vehicle(int idVehicle,
                   int bookingPriceInCents,
                   int pricePerKilometerInCents,
                   int taxHorses) {

        this.idVehicle = idVehicle;
        this.bookingPriceInCents = bookingPriceInCents;
        this.pricePerKilometerInCents = pricePerKilometerInCents;
        this.taxHorses = taxHorses;
    }

    // Getter and setter methods for each field.
    // These allow controlled access and modification of the fields by other classes.

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getBookingPriceInCents() {
        return bookingPriceInCents;
    }

    public void setBookingPriceInCents(int bookingPriceInCents) {
        this.bookingPriceInCents = bookingPriceInCents;
    }

    public int getPricePerKilometerInCents() {
        return pricePerKilometerInCents;
    }

    public void setPricePerKilometerInCents(int pricePerKilometerInCents) {
        this.pricePerKilometerInCents = pricePerKilometerInCents;
    }

    public int getTaxHorses() {
        return taxHorses;
    }

    public void setTaxHorses(int taxHorses) {
        this.taxHorses = taxHorses;
    }
}
