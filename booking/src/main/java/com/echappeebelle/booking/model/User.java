package com.echappeebelle.booking.model;

public class User {


    private int id;
    private String name;
    private String first_name;
    private String birth_date;
    private String license_number;
    private String license_obtention_date;
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

        this.first_name = first_name;

        this.name = name;

        this.birth_date = birth_date;

        this.license_number = license_number;

        this.license_obtention_date = license_obtention_date;

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
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
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
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }
    //GETTER SETTER LICENSE NUMBER**********************************************************************************

    public String getLicense_number() {
        return license_number;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }
    //GETTER SETTER LICENSE NUMBER**********************************************************************************
    public String getLicense_obtention_date() {
        return license_obtention_date;
    }
    public void setLicense_obtention_date(String license_obtention_date) {
        this.license_obtention_date = license_obtention_date;
    }
    //GETTER SETTER AGE*********************************************************************************************
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}



