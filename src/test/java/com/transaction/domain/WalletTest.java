package com.transaction.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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

}