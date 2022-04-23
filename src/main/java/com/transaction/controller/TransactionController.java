package com.transaction.controller;

import com.transaction.config.CheckClientAuthority;
import com.transaction.handler.TransactionHandler;
import com.transaction.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/transactions")
@RequestMapping()
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionHandler transactionHandler;

    @PostMapping
    @CheckClientAuthority
    public void performTransaction(TransactionModel transactionModel) {

    }
}
