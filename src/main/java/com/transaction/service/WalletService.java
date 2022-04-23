package com.transaction.service;

import java.math.BigDecimal;

public interface WalletService {

    BigDecimal calculateBalance(Long accountId);
}
