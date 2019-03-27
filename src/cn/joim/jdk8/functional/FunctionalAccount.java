package cn.joim.jdk8.functional;

import java.math.BigDecimal;
import java.util.Date;

public class FunctionalAccount {

    private final String no;
    private final String name;
    private final Date dateOfOpening;

    private final Balance balance;

    public FunctionalAccount(String no, String name) {
        this.no = no;
        this.name = name;
        dateOfOpening = new Date();

        balance = new Balance();
    }

    public FunctionalAccount(String no, String name, Balance balance) {
        this.no = no;
        this.name = name;
        this.dateOfOpening = new Date();
        this.balance = balance;
    }

    FunctionalAccount(String no, String name, Date dateOfOpening, Balance balance) {
        this.no = no;
        this.name = name;
        this.dateOfOpening = dateOfOpening;
        this.balance = balance;
    }

    public FunctionalAccount debit(BigDecimal a) {

        if (balance.amount().compareTo(a) < 0) {
            throw new RuntimeException("Insufficient balance in account!");
        }
        return new FunctionalAccount(no, name, dateOfOpening,
                new Balance(balance.amount().subtract(a)));
    }

    public FunctionalAccount creadit(BigDecimal a) {
        return new FunctionalAccount(no, name, dateOfOpening,
                new Balance(a));
    }

    public Balance balance() {
        return balance;
    }


}
