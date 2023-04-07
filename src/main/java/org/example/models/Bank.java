package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
public class Bank {
    private String name;
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<Account>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setBank(this);
    }
    public void transfer(Account source, Account destination, BigDecimal amount) {
        source.debit(amount);
        destination.credit(amount);
    }
}
