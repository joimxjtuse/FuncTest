package cn.joim.jdk8.functional;

import java.math.BigDecimal;
import java.util.Date;


public class OldAccount {

    private final String no;
    private final String name;
    private final Date dateOfOpening;

    private Balance balance = new Balance();

    public OldAccount(String no, String name) {
        this.no = no;
        this.name = name;
        dateOfOpening = new Date();
    }


    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Balance balance() {
        return balance;
    }


    public void debit(BigDecimal a) {

        if (balance.amount().compareTo(a) < 0) {
            throw new RuntimeException("Insufficient balance in account!");
        }
        balance.setAmount(balance.amount().subtract(a));
    }

    public void creadit(BigDecimal a) {
        balance.setAmount(a);
    }
}
