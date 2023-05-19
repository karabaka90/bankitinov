package com.balekiss.test.model;

import java.util.List;

public class ClientAccount {

    private Client client;
    private List<Account> clientAccounts;
    private String identifier ;
    private String pwd;

    public ClientAccount(){}




    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<Account> getClientAccounts() {
        return clientAccounts;
    }

    public void setClientAccounts(List<Account> clientAccounts) {
        this.clientAccounts = clientAccounts;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
