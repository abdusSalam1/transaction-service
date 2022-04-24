package com.transaction.service;

import com.transaction.domain.Transaction;
import com.transaction.domain.Wallet;
import com.transaction.exception.AccountNotFoundException;
import com.transaction.exception.DuplicateWalletException;
import com.transaction.exception.InSufficientBalanceException;

import java.math.BigDecimal;

public interface WalletService {

    BigDecimal calculateBalance(Long accountId) throws AccountNotFoundException;

    void save(Wallet wallet) throws DuplicateWalletException;

    Transaction performTransaction(Long accountId, Transaction transaction) throws InSufficientBalanceException, AccountNotFoundException;
}
