package com.echappeebelle.booking.model;

public class User {


    private int id;
    private String name;
    private String firstName;
    private String birthDate;
    private String licenseNumber;
    private String licenseObtentionDate;
    private int age;

    //CONSTRUCTOR*******************************************************************************************************

    public User(int id,
                String name,
                String first_name,
                String birth_date,
                String license_number,
                String license_obtention_date,
                int age){

        this.id = id;

        this.firstName = first_name;

        this.name = name;

        this.birthDate = birth_date;

        this.licenseNumber = license_number;

        this.licenseObtentionDate = license_obtention_date;

        this.age = age;

    }

    public User() {

    }

    //GETTER SETTER*************************************************************************************************

    //GETTER SETTER ID *********************************************************************************************

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //GETTER SETTER PRENOM *****************************************************************************************

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }
    //GETTER SETTER NOM*********************************************************************************************

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //GETTER SETTER DATE NAISSANCE**********************************************************************************


    public String getBirth_date() {
        return birthDate;
    }

    public void setBirth_date(String birth_date) {
        this.birthDate = birth_date;
    }
    //GETTER SETTER LICENSE NUMBER**********************************************************************************

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    //GETTER SETTER LICENSE NUMBER**********************************************************************************
    public String getLicenseObtentionDate() {
        return licenseObtentionDate;
    }
    public void setLicenseObtentionDate(String licenseObtentionDate) {
        this.licenseObtentionDate = licenseObtentionDate;
    }
    //GETTER SETTER AGE*********************************************************************************************
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}



