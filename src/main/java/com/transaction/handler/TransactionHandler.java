package com.transaction.handler;

import com.transaction.model.TransactionModel;
import com.transaction.model.TransactionResponseModel;
import com.transaction.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionHandler {

    private final WalletService walletService;

    public TransactionResponseModel performTransaction(String accountId, TransactionModel transactionModel) {
        return null;
    }
}
