package com.transaction.controller;

import com.transaction.config.CheckClientAuthority;
import com.transaction.handler.TransactionHandler;
import com.transaction.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("/transactions")
@RequestMapping()
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionHandler transactionHandler;

    @PostMapping("/{accountId}")
    @CheckClientAuthority
    public void performTransaction(@PathVariable String accountId, @RequestBody TransactionModel transactionModel) {
        transactionHandler.performTransaction(accountId, transactionModel);
    }
}
