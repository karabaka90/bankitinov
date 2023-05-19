package com.balekiss.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private static Long Id;
    public static String name;
    public static String surname ;
    public static Date dateOfBirth;
    public static String email;
    public static String adress;
    public static String cityZip;
    public static String city;
    public static String phoneNumber;


    public Person(){}
    public Person(String name , String surname , Date dateOfBirth){
        this.name=name;
        this.surname=surname;
        this.dateOfBirth = dateOfBirth;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Person.email = email;
    }

    public static String getAdress() {
        return adress;
    }

    public static void setAdress(String adress) {
        Person.adress = adress;
    }

    public static String getCityZip() {
        return cityZip;
    }

    public static void setCityZip(String cityZip) {
        Person.cityZip = cityZip;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        Person.city = city;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        Person.phoneNumber = phoneNumber;
    }

    @Id
    public  Long getId() {
        return Id;
    }

    public  void setId(Long id) {
        this.Id = id;
    }

    public  String getName() {
        return name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public  String getSurname() {
        return surname;
    }

    public  void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public  void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
