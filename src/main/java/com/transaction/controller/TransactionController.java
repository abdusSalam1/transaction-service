package com.transaction.controller;

import com.transaction.config.CheckClientAuthority;
import com.transaction.handler.TransactionHandler;
import com.transaction.model.TransactionModel;
import com.transaction.model.TransactionResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("/transactions")
@RequestMapping()
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionHandler transactionHandler;

    @PostMapping("/{accountId}")
    @CheckClientAuthority
    public TransactionResponseModel performTransaction(@PathVariable String accountId, @RequestBody TransactionModel transactionModel) {
        return transactionHandler.performTransaction(accountId,transactionModel);
    }
}
