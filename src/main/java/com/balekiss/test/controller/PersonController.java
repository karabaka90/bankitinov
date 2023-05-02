package com.balekiss.test.controller;


import com.balekiss.test.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class PersonController {
    public final static Integer maximumAge = 150;

    @GetMapping("/")
    public String showPersons(Model model) {
        try {
            model.addAttribute("newPerson", new Person() {
            });

        } catch (Exception e) {
            e.toString();
        }
        return "webAtrio";
    }

    @RequestMapping(value = "/postPerson", method = RequestMethod.POST)
    public String createCourse(@ModelAttribute Person newPerson, Model model) {
        try {
            if (checkDate(newPerson.getDateOfBirth())) {
                Person person = new Person(newPerson.getName(), newPerson.getSurname(), newPerson.getDateOfBirth());
                model.addAttribute("name", person.getName());
                model.addAttribute("surname", person.getSurname());
                model.addAttribute("dateOfBirth", person.getDateOfBirth());
                model.addAttribute("newPerson", new Person());
            }
            else{
                model.addAttribute("name", newPerson.getName());
                model.addAttribute("surname", newPerson.getSurname());
                model.addAttribute("dateOfBirth", newPerson.getDateOfBirth());
                model.addAttribute("newPerson", new Person());
                return "erreur-webAtrio.html";
            }

        } catch (Exception e) {
            e.toString();
        }
        return "webAtrio";
    }

    public static boolean checkDate(Date dateOfBirth) {
        Date now = new Date();
        int difference = now.getYear() - dateOfBirth.getYear();
        if (difference >= maximumAge){
            return false;
        }
        return true;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

        dataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                } catch (ParseException e) {
                    setValue(null);
                }
            }
        });

    }

}
