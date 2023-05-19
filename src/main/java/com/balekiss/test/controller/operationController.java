package com.balekiss.test.controller;


import com.balekiss.test.model.Account;
import com.balekiss.test.model.Client;
import com.balekiss.test.model.ClientAccount;
import com.balekiss.test.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.balekiss.test.controller.ConnexionController.getClientAccountSession;

@Controller
public class operationController {
    public final static Integer maximumAge = 150;
    /**
     * show All operations , add operations by user
     * @deprecated
     *
     * @param machine instance
     * @return list Of person
     */
    @Deprecated
    @GetMapping(value = "/showOperations/{accountId}")
    public String showOperations(@PathVariable String accountId, Model model) {
        try {
            ClientAccount clientAccount = getClientAccountSession();
            model.addAttribute("clientAccount",clientAccount);

            /*Account returnedAccount = clientAccount.getClientAccounts().stream().filter( account -> accountId.toString().equals(account.getID().toString()))
                    .findAny()
                    .orElse(null);
            */
            // error de set with stream ... // todo
            for (Account  account :clientAccount.getClientAccounts()) {
                if (accountId.toString().equals(account.getID().toString())){
                    model.addAttribute("operations",account.getAccountOperations());
                    model.addAttribute("solde",account.getBalance());
                    break;
                }
            }

        } catch (Exception e) {
            e.toString();
        }
        return "showOp";
    }




    /**
     * Save person and test his age
     * @deprecated
     *
     * @param machine instance
     * @return ok if its ok and error if its more than 150 years
     */
    @Deprecated
    @RequestMapping(value = "/newOperation", method = RequestMethod.POST)
    public String createOperation(@ModelAttribute Person newPerson, Model model) {
        try {
            getClientAccountSession();




        } catch (Exception e) {
            e.toString();
        }
        return "newOp";
    }





    /**
     * Calculate period between two date if its 150 years
     * @deprecated
     *
     * @param machine instance
     * @return true or false
     */
    @Deprecated
    public static boolean checkSolde(Date dateOfBirth) {
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
