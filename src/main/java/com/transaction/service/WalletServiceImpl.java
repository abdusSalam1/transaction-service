package com.transaction.service;

import com.transaction.domain.Wallet;
import com.transaction.exception.DuplicateAccountException;
import com.transaction.exception.DuplicateWalletException;
import com.transaction.repository.TransactionRepository;
import com.transaction.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public BigDecimal calculateBalance(Long accountId) {
        return null;
    }

    @Override
    public void save(Wallet wallet) throws DuplicateWalletException {
        if(walletRepository.findByWallet_Account_Id(wallet.getAccount().getId()) != null)
            throw new DuplicateWalletException();
        walletRepository.save(wallet);
    }
}
