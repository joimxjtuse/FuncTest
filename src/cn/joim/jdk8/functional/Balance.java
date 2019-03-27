package cn.joim.jdk8.functional;

import java.math.BigDecimal;

public class Balance {

    private BigDecimal amount;

    public Balance() {
        this.amount = BigDecimal.valueOf(0);
    }

    public Balance(BigDecimal amount) {
        this.amount = amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal amount() {
        return amount;
    }
}
