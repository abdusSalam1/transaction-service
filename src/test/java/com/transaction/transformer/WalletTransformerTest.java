package com.transaction.transformer;

import com.transaction.domain.Wallet;
import com.transaction.model.AccountModel;
import com.transaction.model.WalletModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class WalletTransformerTest {

    private AccountTransformer accountTransformer;
    private WalletTransformer walletTransformer;

    @BeforeEach
    public void setup() {
        this.accountTransformer = new AccountTransformer();
        this.walletTransformer = new WalletTransformer(accountTransformer);
    }

    @Test
    public void whenNullModelGivenShouldReturnNull() {
        WalletModel model = null;
        Wallet entity = walletTransformer.toEntity(model);
        Assertions.assertNull(entity);
    }

    @Test
    public void whenModelGivenShouldReturnEntity() {
        WalletModel model = WalletModel.builder()
                .account(AccountModel.builder().id(123L).build())
                .amount(new BigDecimal(200))
                .description("added for test")
                .purpose("bought a new phone")
                .build();
        Wallet entity = walletTransformer.toEntity(model);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(123L, entity.getAccount().getId());
        Assertions.assertEquals("added for test", entity.getDescription());
        Assertions.assertEquals("bought a new phone", entity.getPurpose());
    }

    @Test
    public void whenNullEntityGivenShouldReturnNull() {
        Wallet entity = null;
        WalletModel model = walletTransformer.toModel(entity);
        Assertions.assertNull(entity);
    }

}