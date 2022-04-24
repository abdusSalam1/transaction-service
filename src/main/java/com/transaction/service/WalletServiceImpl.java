package com.transaction.service;

import com.transaction.domain.NotificationType;
import com.transaction.domain.Transaction;
import com.transaction.domain.Wallet;
import com.transaction.enums.TransactionType;
import com.transaction.exception.AccountNotFoundException;
import com.transaction.exception.DuplicateWalletException;
import com.transaction.exception.InSufficientBalanceException;
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
    private final NotificationService notificationService;

    @Override
    public BigDecimal calculateBalance(Long accountId) throws AccountNotFoundException {
        Wallet wallet = walletRepository.findByAccount_Id(accountId).orElseThrow(AccountNotFoundException::new);
        return wallet.getBalance();
    }

    @Override
    public void save(Wallet wallet) throws DuplicateWalletException {
        if (walletRepository.findByAccount_Id(wallet.getAccount().getId()).isPresent())
            throw new DuplicateWalletException();
        walletRepository.save(wallet);
    }


    @Override
    public Transaction performTransaction(Long accountId, Transaction transaction) throws InSufficientBalanceException, AccountNotFoundException {
        Wallet wallet = walletRepository.findByAccount_Id(accountId).orElseThrow(AccountNotFoundException::new);
        transaction.setWallet(wallet);
        validateBalance(wallet, transaction);
        transaction = transactionRepository.save(transaction);
        switch (transaction.getType()) {
            case DEBIT:
                wallet.subtractBalance(transaction.getAmount());
                //TODO: Can update this method as per need not passing any transaction data for now
                notificationService.sendEmail(NotificationType.DEBIT_TRANSACTION,wallet.getAccount().getEmail());
                break;
            case CREDIT:
                wallet.addBalance(transaction.getAmount());
                //TODO: Can update this method as per need not passing any transaction data for now
                notificationService.sendEmail(NotificationType.CREDIT_TRANSACTION,wallet.getAccount().getEmail());
                break;
            default:
                throw new IllegalArgumentException("Invalid transaction type");
        }
        walletRepository.save(wallet);
        return transaction;
    }

    private void validateBalance(Wallet wallet, Transaction transactionModel) throws InSufficientBalanceException {
        if (transactionModel.getType().equals(TransactionType.DEBIT) && transactionModel.getAmount().compareTo(wallet.getBalance()) > 0) {
            throw new InSufficientBalanceException();
        }
    }
}
