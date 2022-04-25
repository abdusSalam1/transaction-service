package com.transaction.transformer;

import com.transaction.domain.Transaction;
import com.transaction.enums.TransactionType;
import com.transaction.model.TransactionModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class TransactionTransformerTest {

    private TransactionTransformer transactionTransformer;

    @BeforeEach
    public void setup() {
        this.transactionTransformer = new TransactionTransformer();
    }

    @Test
    public void whenNullModelGivenShouldReturnNull() {
        TransactionModel model = null;
        Transaction entity = transactionTransformer.toEntity(model);
        Assertions.assertNull(entity);
    }

    @Test
    public void whenModelGivenShouldReturnEntity() {
        TransactionModel model = TransactionModel.builder()
                .amount(new BigDecimal(200))
                .description("added for test")
                .purpose("bought a new phone")
                .creditAccount("1234")
                .transactionType(TransactionType.DEBIT)
                .build();
        Transaction entity = transactionTransformer.toEntity(model);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals("added for test", entity.getDescription());
        Assertions.assertEquals("bought a new phone", entity.getPurpose());
        Assertions.assertEquals("1234", entity.getCreditAccount());
        Assertions.assertEquals(TransactionType.DEBIT, entity.getType());
        Assertions.assertNotNull(entity.getReference());
        Assertions.assertNotNull(entity.getTransactionDate());
    }

    @Test
    public void whenNullEntityGivenShouldReturnNull() {
        Transaction entity = null;
        TransactionModel model = transactionTransformer.toModel(entity);
        Assertions.assertNull(model);
    }

    @Test
    public void whenEntityGivenShouldReturnModel() {
        Transaction entity = Transaction.builder()
                .amount(new BigDecimal(200))
                .description("added for test")
                .purpose("bought a new phone")
                .creditAccount("1234")
                .type(TransactionType.DEBIT)
                .reference("123")
                .transactionDate(LocalDateTime.now())
                .id(1L)
                .build();
        TransactionModel model = transactionTransformer.toModel(entity);
        Assertions.assertNotNull(model);
        Assertions.assertEquals("added for test", model.getDescription());
        Assertions.assertEquals("bought a new phone", model.getPurpose());
        Assertions.assertEquals("1234", model.getCreditAccount());
        Assertions.assertEquals(TransactionType.DEBIT, model.getTransactionType());
    }

}