package com.transaction.controller;

import com.transaction.config.CheckClientAuthority;
import com.transaction.handler.BalanceHandler;
import com.transaction.model.BalanceModel;
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
    public BalanceModel getBalance(@PathVariable String accountId) {
        return balanceHandler.getBalance(accountId);
    }
}
