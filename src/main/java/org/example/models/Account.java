package org.example.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.example.exceptions.InsuficcientMoneyException;

import java.math.BigDecimal;

@Data
@ToString
@Builder
public class Account {
    private String person;
    private BigDecimal balance;
    private Bank bank;

    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Account)) return false;
        Account account = (Account) o;
        if(this.person == null || this.balance == null) return false;

        return this.person.equals(account.getPerson()) && this.balance.equals(account.getBalance());
    }

    public void debit(BigDecimal amount) {
        if(this.balance.compareTo(amount) < 0) throw new InsuficcientMoneyException("Insufficient money");
        this.balance = this.balance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }
}
