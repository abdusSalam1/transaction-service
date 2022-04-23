package com.transaction.service;

import com.transaction.repository.TransactionRepository;
import com.transaction.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public BigDecimal calculateBalance(Long accountId) {
        return null;
    }
}
