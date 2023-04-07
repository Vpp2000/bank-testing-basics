package org.example;

import org.example.exceptions.InsuficcientMoneyException;
import org.example.models.Account;
import org.example.models.Bank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        assertEquals("900.125", debitAccount.getBalance().toPlainString());
    }

    @Test
    @DisplayName("Test credit account")
    void test_credit_account() {
        Account creditAccount = Account.builder()
                .person("Victor")
                .balance(new BigDecimal("1000.125"))
                //.balance(null)
                .build();
        assertNotNull(creditAccount.getBalance(), "The amout of money cannot be null");
        creditAccount.credit(new BigDecimal("100"));
        assertEquals(1100, creditAccount.getBalance().intValue());
        assertEquals("1100.125", creditAccount.getBalance().toPlainString());

    }

    @Test
    @DisplayName("Test account with not enough balance throw exception")
    public void test_account_with_not_enough_balance_throw_exception() {
        Account debitAccount = Account.builder()
                .person("Victor")
                .balance(new BigDecimal("400.125"))
                .build();
        Exception exception = assertThrows(InsuficcientMoneyException.class, () -> {
            debitAccount.debit(new BigDecimal("1000"));
        });
        String expectedMessage = "Insufficient money";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    @DisplayName("Test money transference between accounts")
    public void test_money_transference_between_accounts(){
        Account source = Account.builder()
                .person("John")
                .balance(new BigDecimal("800.0"))
                .build();


        Account destiny = Account.builder()
                .person("Victor")
                .balance(new BigDecimal("450.0"))
                .build();

        Bank bank = new Bank();
        bank.setName("Scotiabank");

        bank.transfer(source, destiny, new BigDecimal("100.0"));
        assertEquals("700.0", source.getBalance().toPlainString());
        assertEquals("550.0", destiny.getBalance().toPlainString());
    }

    @Test
    @DisplayName("Test relation bank account")
    public void test_relation_bank_account(){
        Account source = Account.builder()
                .person("John")
                .balance(new BigDecimal("800.0"))
                .build();


        Account destiny = Account.builder()
                .person("Victor")
                .balance(new BigDecimal("450.0"))
                .build();

        Bank bank = new Bank();
        bank.setName("Scotiabank");

        bank.addAccount(source);
        bank.addAccount(destiny);

        assertAll(
                () -> assertEquals(2, bank.getAccounts().size()),
                () -> assertEquals("Scotiabank", source.getBank().getName()),
                () -> assertEquals("Victor",bank.getAccounts().stream()
                        .filter(c -> c.getPerson().equals("Victor"))
                        .findFirst()
                        .get()
                        .getPerson()),
                () -> assertTrue(bank.getAccounts().stream().anyMatch(c -> c.getPerson().equals("Victor")))
        );

        /*
        assertEquals(2, bank.getAccounts().size());
        assertEquals("Scotiabank", source.getBank().getName());
        assertEquals("Victor",bank.getAccounts().stream()
                .filter(c -> c.getPerson().equals("Victor"))
                .findFirst()
                .get()
                .getPerson());

        assertTrue(bank.getAccounts().stream().anyMatch(c -> c.getPerson().equals("Victor")));
        */
    }
}