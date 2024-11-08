package com.echappeebelle.booking.model;



import jakarta.persistence.*;


public class Vehicle{

    private int idVehicle;

    private String plateNumber;
    private String brand;
    private String model;
    private String color;
    private int bookingPriceInCents;
    private int pricePerKilometerInCents;
    private int taxHorses;
    private String type;
    // Maps the 'type' field to the discriminator column for read-only purposes.
    // 'insertable = false, updatable = false' prevents conflicts since Hibernate controls this column.




    public Vehicle() {
    }

    public Vehicle(int idVehicle, String plateNumber, String brand, String model, String color,
                   int bookingPriceInCents, int pricePerKilometerInCents, int taxHorses, String type) {
        this.idVehicle = idVehicle;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.bookingPriceInCents = bookingPriceInCents;
        this.pricePerKilometerInCents = pricePerKilometerInCents;
        this.taxHorses = taxHorses;
        this.type = type;
    }

    // Getter and setter methods for each field.
    // These allow controlled access and modification of the fields by other classes.

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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