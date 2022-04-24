package com.transaction.transformer;

import com.transaction.domain.Transaction;
import com.transaction.generator.ReferenceGenerator;
import com.transaction.generator.ReferenceGeneratorImpl;
import com.transaction.model.TransactionModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class TransactionTransformerTest {

    private ReferenceGenerator referenceGenerator;
    private TransactionTransformer transactionTransformer;

    @BeforeEach
    public void setup() {
        this.referenceGenerator = new ReferenceGeneratorImpl();
        this.transactionTransformer = new TransactionTransformer(referenceGenerator);
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
                .build();
        Transaction entity = transactionTransformer.toEntity(model);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals("added for test", entity.getDescription());
        Assertions.assertEquals("bought a new phone", entity.getPurpose());
    }

    @Test
    public void whenNullEntityGivenShouldReturnNull() {
        Transaction entity = null;
        TransactionModel model = transactionTransformer.toModel(entity);
        Assertions.assertNull(model);
    }

}