package com.transaction.handler;

import com.transaction.model.TransactionModel;
import com.transaction.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionHandler {

    private final WalletService walletService;

    public void performTransaction(String accountId, TransactionModel transactionModel) {
    }
}
