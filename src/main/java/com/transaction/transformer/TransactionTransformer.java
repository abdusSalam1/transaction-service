package com.transaction.transformer;

import com.transaction.domain.Transaction;
import com.transaction.generator.ReferenceGenerator;
import com.transaction.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TransactionTransformer implements Transformer<TransactionModel, Transaction> {

    private final ReferenceGenerator referenceGenerator;

    @Override
    public Transaction toEntity(TransactionModel model) {
        if (model == null)
            return null;
        else
            return Transaction.builder()
                    .transactionDate(LocalDateTime.now())
                    .reference(referenceGenerator.generateReference())
                    .amount(model.getAmount())
                    .purpose(model.getPurpose())
                    .description(model.getDescription())
                    .creditAccount(model.getCreditAccount())
                    .type(model.getTransactionType())
                    .build();
    }

    @Override
    public TransactionModel toModel(Transaction entity) {
        if (entity == null)
            return null;
        else
            return TransactionModel.builder()
                    .amount(entity.getAmount())
                    .purpose(entity.getPurpose())
                    .description(entity.getDescription())
                    .creditAccount(entity.getCreditAccount())
                    .transactionType(entity.getType())
                    .build();
    }
}
