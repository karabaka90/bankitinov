package com.balekiss.test.model;

import java.util.List;

public class Account {
   private Long ID;

    private String RIB;

    private String numCompte;
    @Deprecated
    /**
     * expected SQL JOB ( listner ) to calculate current Balance
     * @deprecated
     *
     * @param machine instance
     * @return ok if its ok and error if its more than 150 years
     */

    private double balance;
    @Deprecated
    /**
     * expected SQL JOB ( listner ) to calculate last Balance
     * @deprecated
     *
     * @param machine instance
     * @return ok if its ok and error if its more than 150 years
     */

    private double lastBalance ;

    private List<AccountOperation> accountOperations;

    private Client client;

    private AccountType accountType ;

    /**
     * variable qui gére la facilité de caisse
     * @deprecated
     *
     * @param machine instance
     * @return true or false
     */
    @Deprecated
    private Double overdraft ; //facilite de caisse

    public Account(){}

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<AccountOperation> getAccountOperations() {
        return accountOperations;
    }

    public void setAccountOperations(List<AccountOperation> accountOperations) {
        this.accountOperations = accountOperations;
    }

    public double getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(double lastBalance) {
        this.lastBalance = lastBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public String getRIB() {
        return RIB;
    }

    public void setRIB(String RIB) {
        this.RIB = RIB;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Double getOverdraft(){
        return overdraft;
    }

    public void setOverdraft(Double overdraft){
        this.overdraft=overdraft;
    }
}
