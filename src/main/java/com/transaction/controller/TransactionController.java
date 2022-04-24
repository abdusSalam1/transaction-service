package com.transaction.controller;

import com.transaction.exception.AccountNotFoundException;
import com.transaction.exception.InSufficientBalanceException;
import com.transaction.handler.TransactionHandler;
import com.transaction.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionHandler transactionHandler;

    @PostMapping("/{accountId}")
    public TransactionModel performTransaction(@PathVariable Long accountId, @RequestBody TransactionModel transactionModel) throws InSufficientBalanceException, AccountNotFoundException {
        return transactionHandler.performTransaction(accountId, transactionModel);
    }
}
