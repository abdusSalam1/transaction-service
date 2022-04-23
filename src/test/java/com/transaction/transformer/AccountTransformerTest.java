package com.transaction.transformer;


import com.transaction.domain.Account;
import com.transaction.model.AccountModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTransformerTest {

    private AccountTransformer accountTransformer;

    @BeforeEach
    public void setup() {
        accountTransformer = new AccountTransformer();
    }

    @Test
    public void whenNullAccountModelShouldReturnNullEntity() {
        //given
        AccountModel accountModel = null;
        //when
        Account account = accountTransformer.toEntity(accountModel);
        //then
        Assertions.assertNull(account);
    }

    @Test
    public void whenAccountModelShouldReturnNull() {
        //given
        AccountModel accountModel = AccountModel.builder()
                .name("test_name")
                .email("test@email.com")
                .build();
        //when
        Account account = accountTransformer.toEntity(accountModel);
        //then
        Assertions.assertNotNull(account);
        Assertions.assertEquals("test_name", account.getName());
        Assertions.assertEquals("test@email.com", account.getEmail());
    }

    @Test
    public void whenNullAccountShouldReturnEmptyModel() {
        //given
        Account account = null;
        //when
        AccountModel accountModel = accountTransformer.toModel(account);
        //then
        Assertions.assertNull(accountModel);
    }

    @Test
    public void whenAccountShouldReturnConvertedModel() {
        //given
        Account account = Account.builder()
                .id(123L)
                .name("test_name")
                .email("test@email.com")
                .build();
        //when
        AccountModel accountModel = accountTransformer.toModel(account);
        //then
        Assertions.assertNotNull(accountModel);
        Assertions.assertEquals(123L, accountModel.getId());
        Assertions.assertEquals("test_name", accountModel.getName());
        Assertions.assertEquals("test@email.com", accountModel.getEmail());
    }

}