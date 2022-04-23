package com.transaction.service;

import com.transaction.domain.Wallet;
import com.transaction.exception.DuplicateWalletException;

import java.math.BigDecimal;

public interface WalletService {

    BigDecimal calculateBalance(Long accountId);

    void save(Wallet wallet) throws DuplicateWalletException;
}
