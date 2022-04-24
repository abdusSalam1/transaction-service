package com.transaction.handler;

import com.transaction.exception.AccountNotFoundException;
import com.transaction.model.BalanceModel;
import com.transaction.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class BalanceHandler {

    private final WalletService walletService;

    public BalanceModel getBalance(Long accountId) throws AccountNotFoundException {
       BigDecimal balance = walletService.calculateBalance(accountId);
       return BalanceModel.builder().balance(balance).build();
    }
}
