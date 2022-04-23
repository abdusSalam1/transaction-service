package com.transaction.handler;

import com.transaction.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BalanceHandler {

    private final WalletService walletService;

    public void getBalance(String accountId) {
    }
}
