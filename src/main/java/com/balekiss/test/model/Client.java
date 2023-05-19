package com.balekiss.test.model;

import java.util.Date;

public class Client extends Person{

    public Client(){

    }

    public Client(String name, String surname, Date dateOfBirth , String email , String phoneNumber , String adress , String cityZip , String city) {
        this.name = name;
        this.surname=surname;
        this.dateOfBirth=dateOfBirth;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.adress=adress;
        this.cityZip=cityZip;
        this.city=city;
    }

}
