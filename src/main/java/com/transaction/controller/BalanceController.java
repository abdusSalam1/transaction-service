package com.transaction.controller;

import com.transaction.config.CheckClientAuthority;
import com.transaction.handler.TransactionHandler;
import com.transaction.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/balances")
@RequestMapping()
@RequiredArgsConstructor
public class BalanceController {

    private final TransactionHandler transactionHandler;

    @GetMapping
    @CheckClientAuthority
    public void getBalance() {

    }
}
