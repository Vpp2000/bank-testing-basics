package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {
    static Account account;

    @BeforeAll
    static void setupAccount() {
        account = Account.builder()
                .person("Victor")
                .balance(new BigDecimal("450.125"))
                .build();
    }

    @Test
    @DisplayName("Test name account")
    void test_name_account() {
        String expected = "Victor";
        String actual = account.getPerson();

        assertEquals(expected, actual);
        // assertTrue(actual.equals(expected));
    }

    @Test
    @DisplayName("Test balance account")
    void test_balance_account() {
        assertEquals(450.125, account.getBalance().doubleValue());
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    @DisplayName("Test account equality")
    void test_account_equality() {
        Account account2 = Account.builder()
                .person("Victor")
                .balance(new BigDecimal("450.125"))
                .build();

        assertEquals(account,account2);
    }

    @Test
    @DisplayName("Test debit account")
    void test_debit_account() {
        Account debitAccount = Account.builder()
                .person("Victor")
                .balance(new BigDecimal("1000.125"))
                .build();
        debitAccount.debit(new BigDecimal("100"));

        assertNotNull(debitAccount.getBalance());
        assertEquals(900, debitAccount.getBalance().intValue());
    }

    @Test
    @DisplayName("Test credit account")
    void test_credit_account() {
        Account creditAccount = Account.builder()
                .person("Victor")
                .balance(new BigDecimal("1000.125"))
                .build();
        creditAccount.credit(new BigDecimal("100"));
        assertNotNull(creditAccount.getBalance());
        assertEquals(1100, creditAccount.getBalance().intValue());
    }
}