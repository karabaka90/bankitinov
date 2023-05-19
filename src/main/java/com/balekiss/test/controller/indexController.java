package com.balekiss.test.controller;


import com.balekiss.test.model.ClientAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class indexController {
    /**
     * show index page
     * @deprecated
     *
     * @param machine instance
     * @return list Of person
     */
    @Deprecated
    @GetMapping("/")
    public String returnIndexPage(Model model) {
        return "itinovBank";
    }
}
