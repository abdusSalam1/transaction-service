package com.transaction.controller;

import com.transaction.config.CheckClientAuthority;
import com.transaction.handler.BalanceHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/balances")
@RequestMapping()
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceHandler balanceHandler;

    @GetMapping("/{accountId}")
    @CheckClientAuthority
    public void getBalance(@PathVariable String accountId) {
        balanceHandler.getBalance(accountId);
    }
}
