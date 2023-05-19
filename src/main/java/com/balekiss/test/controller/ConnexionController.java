package com.balekiss.test.controller;

import com.balekiss.test.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ConnexionController {
    public final static Integer maximumAge = 150;

    private static ClientAccount clientAccountSession;
    /**
     * show All operations , add operations by user
     *
     * @param machine instance
     * @return list Of person
     * @deprecated
     */
    @Deprecated
    @GetMapping("/connexion")
    public String createConnexion(Model model) {
        try {
            ClientAccount newCnx = new ClientAccount();
            model.addAttribute("newClientAccount", newCnx);

        } catch (Exception e) {
            e.toString();
        }
        return "login";
    }


    /**
     * Save person and test his age
     *
     * @param machine instance
     * @return ok if its ok and error if its more than 150 years
     * @deprecated
     */
    @Deprecated

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String createConnexion(@ModelAttribute ClientAccount clientAccount, Model model) {
        try {
            if (checkUser(clientAccount)) {
                initiliaseView(clientAccount,model);
                return "itinovBank-Accueil-Client";
            } else {
                ClientAccount newCnx = new ClientAccount();
                model.addAttribute("newClientAccount", newCnx);
                return "erreur-login";
            }
        } catch (Exception e) {
            e.toString();
        }
        return "itinovBank";
    }

    private void initiliaseView(ClientAccount clientAccount, Model model) throws ParseException {
       //jeux de données pour exemples ..
        Client client = new Client();
        client.setName("Eric");
        client.setSurname("demo");
        client.setId(78551269454212L);
        clientAccount.setClient(client);

        List<Account> clientAccounts = new ArrayList<>();

        Account account1 = new Account();
        account1.setID(1L);
        account1.setRIB("FR7630001007941234567890185");
        account1.setNumCompte("040 00000 901");
        account1.setClient(client);
        account1.setLastBalance(5987.45);
        account1.setBalance(5350.00);
        account1.setOverdraft(1000.0);
        List<AccountOperation> accountOperations = new ArrayList<>();
        AccountOperation operation1 = new AccountOperation();

        operation1.setSign(Sign.Credit);
        operation1.setLibelle("Virement Salaire VO/TP OO12");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse("12-02-2023");
        operation1.setDate(new Timestamp(date.getTime()));
        operation1.setAccount(account1);
        operation1.setAmount(3490.0);
        accountOperations.add(operation1);
        /* **** */
        AccountOperation operation2=operation1;
        operation2.setAmount(290.0);
        operation2.setSign(Sign.Credit);
        operation2.setLibelle("VIR/CPMS SECU 4548755500");
        accountOperations.add(operation2);
        /* ***** */
        AccountOperation operation3=operation1;
        operation3.setAmount(21.0);
        operation3.setSign(Sign.Debit);
        operation3.setLibelle("REST/KE DELICE 1425485845");
        accountOperations.add(operation3);
        /* ***** */
        AccountOperation operation4=operation1;
        operation4.setAmount(91.0);
        operation4.setSign(Sign.Debit);
        operation4.setLibelle("REST/KE IKEA 005478LL");
        accountOperations.add(operation4);
        /* ***** */
        AccountOperation operation5=operation1;
        operation5.setAmount(1090.0);
        operation5.setSign(Sign.Debit);
        operation5.setLibelle("LOCATIONS/IMR SCO ECK LO 001");
        accountOperations.add(operation5);



        account1.setAccountOperations(accountOperations);
        clientAccounts.add(account1);

        Account account2 = new Account();
        account2.setID(2L);
        account2.setRIB("FR7630004000031234567890143");
        account2.setNumCompte("010 00878 901");
        account2.setClient(client);
        account2.setLastBalance(-63.02);
        account2.setBalance(-3.60);
        account2.setOverdraft(100.0);
        account2.setAccountOperations(accountOperations);
        clientAccounts.add(account2);

        Account account3 = new Account();
        account3.setID(3L);
        account3.setRIB("FR7630006000011234567890189");
        account3.setNumCompte("064 65878 901");
        account3.setClient(client);
        account3.setLastBalance(300.0);
        account3.setBalance(-250.0);
        account3.setOverdraft(0.0);
        account3.setAccountOperations(accountOperations);
        clientAccounts.add(account3);

        clientAccount.setClientAccounts(clientAccounts);

        setClientAccountSession(clientAccount);
        model.addAttribute("client", clientAccount.getClient());
        model.addAttribute("accounts", clientAccount.getClientAccounts());
        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setDate(Timestamp.from(Instant.now()));
        model.addAttribute("newOperation", accountOperation);
    }


    /**
     * Calculate period between two date if its 150 years
     *
     * @param machine instance
     * @return true or false
     * @deprecated
     */
    @Deprecated
    public static boolean checkUser(ClientAccount clientAccount) {
        return clientAccount.getIdentifier().equals("client1") && clientAccount.getPwd().equals("123456");
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

    public static ClientAccount getClientAccountSession() {
        return clientAccountSession;
    }

    public void setClientAccountSession(ClientAccount clientAccountSession) {
        this.clientAccountSession = clientAccountSession;
    }
}
