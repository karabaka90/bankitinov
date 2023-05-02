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
    private static String name;
    private static String surname ;
    private static Date dateOfBirth;

    public Person(){}
    public Person(String name , String surname , Date dateOfBirth){
        this.name=name;
        this.surname=surname;
        this.dateOfBirth = dateOfBirth;
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
