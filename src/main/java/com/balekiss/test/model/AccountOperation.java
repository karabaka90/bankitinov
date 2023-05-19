package com.balekiss.test.model;

import jdk.jfr.StackTrace;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

public class AccountOperation {
    @Getter @Setter
    private Timestamp date;
    @Getter @Setter
    private Account account ;
    @Getter @Setter
    private Double amount;
    @Getter @Setter
    private Sign sign;
    @Getter @Setter
    private String libelle;
}
