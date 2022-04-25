package com.transaction.domain;

import com.transaction.enums.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class WalletTest {


    @Test
    public void givenNullBalanceWhileSubtractingShouldNotUpdateBalance() {
        Wallet wallet = Wallet.builder().balance(new BigDecimal(100)).build();
        wallet.subtractBalance(null);
        Assertions.assertTrue(new BigDecimal(100).equals(wallet.getBalance()));
    }

    @Test
    public void givenNullBalanceWhileAddingShouldNotUpdateBalance() {
        Wallet wallet = Wallet.builder().balance(new BigDecimal(100)).build();
        wallet.addBalance(null);
        Assertions.assertTrue(new BigDecimal(100).equals(wallet.getBalance()));
    }

    @Test
    public void given50BalanceWhileSubtractingShouldUpdateBalance() {
        Wallet wallet = Wallet.builder().balance(new BigDecimal(100)).build();
        wallet.subtractBalance(new BigDecimal(50));
        Assertions.assertTrue(new BigDecimal(50).equals(wallet.getBalance()));
    }

    @Test
    public void given50BalanceWhileAddingShouldUpdateBalance() {
        Wallet wallet = Wallet.builder().balance(new BigDecimal(100)).build();
        wallet.addBalance(new BigDecimal(50));
        Assertions.assertTrue(new BigDecimal(150).equals(wallet.getBalance()));
    }

    @Test
    public void givenNullBalanceWhileGettingShouldReturnZero() {
        Wallet wallet = Wallet.builder().build();
        Assertions.assertTrue(new BigDecimal(0).equals(wallet.getBalance()));
    }

    @Test
    public void givenTransactionWhenValidationShouldReturnValid() {
        Transaction entity = Transaction.builder()
                .amount(new BigDecimal(200))
                .description("added for test")
                .purpose("bought a new phone")
                .creditAccount("1234")
                .type(TransactionType.DEBIT)
                .reference("123")
                .transactionDate(LocalDateTime.now())
                .id(1L)
                .build();
        try {
            Wallet wallet = Wallet.builder().balance(new BigDecimal(200)).build();
            wallet.validateBalance(entity);
        }
        catch (Exception ex){
            Assertions.fail();
        }
    }

    @Test
    public void givenTransactionWhenValidationShouldReturnInValid() {
        Transaction entity = Transaction.builder()
                .amount(new BigDecimal(200))
                .description("added for test")
                .purpose("bought a new phone")
                .creditAccount("1234")
                .type(TransactionType.DEBIT)
                .reference("123")
                .transactionDate(LocalDateTime.now())
                .id(1L)
                .build();
        try {
            Wallet wallet = Wallet.builder().balance(new BigDecimal(0)).build();
            wallet.validateBalance(entity);
            Assertions.fail();
        }
        catch (Exception ex){
        }
    }

}