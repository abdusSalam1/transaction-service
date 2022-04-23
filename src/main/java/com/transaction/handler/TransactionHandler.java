package com.transaction.handler;

import com.transaction.model.WalletModel;
import com.transaction.model.TransactionResponseModel;
import com.transaction.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionHandler {

    private final WalletService walletService;

    public TransactionResponseModel performTransaction(WalletModel transactionModel) {
        return null;
    }
}
