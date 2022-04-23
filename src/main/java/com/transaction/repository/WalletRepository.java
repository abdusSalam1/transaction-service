package com.transaction.repository;

import com.transaction.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
//    Wallet findByWallet_Account_Id(Long id);
}
