package com.transaction.handler;

import com.transaction.domain.Transaction;
import com.transaction.exception.AccountNotFoundException;
import com.transaction.exception.InSufficientBalanceException;
import com.transaction.model.TransactionModel;
import com.transaction.service.WalletService;
import com.transaction.transformer.TransactionTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionHandler {

    private final WalletService walletService;
    private final TransactionTransformer transactionTransformer;

    public TransactionModel performTransaction(Long accountId, TransactionModel model) throws InSufficientBalanceException, AccountNotFoundException {
        Transaction transaction = transactionTransformer.toEntity(model);
        Transaction savedTransaction = walletService.performTransaction(accountId, transaction);
        return transactionTransformer.toModel(savedTransaction);
    }
}
