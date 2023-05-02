package com.balekiss.test.controller;


import com.balekiss.test.data.PersonDAO;
import com.balekiss.test.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class PersonRestController {

    @Autowired
    PersonDAO personDAO;

    @GetMapping("/api/person")
    public List<Person> PersonList() {
        return personDAO.findAll();
    }

    @PostMapping("/api/person")
    public void savePerson(@RequestBody Person person) throws Exception{
        if (PersonController.checkDate(person.getDateOfBirth())) {
            personDAO.save(person);
        }else{
            throw new Exception("l'age maximum est de " + PersonController.maximumAge);
        }
    }
}
