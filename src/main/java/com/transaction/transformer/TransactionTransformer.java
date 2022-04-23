package com.transaction.transformer;

import com.transaction.domain.Transaction;
import com.transaction.model.TransactionModel;
import org.springframework.stereotype.Component;

@Component
public class TransactionTransformer implements Transformer<TransactionModel, Transaction> {

    @Override
    public Transaction toEntity(TransactionModel model) {
        if (model == null)
            return null;
        else
            return Transaction.builder()
                    .amount(model.getAmount())
                    .description(model.getDescription())
                    .purpose(model.getPurpose())
                    .build();
    }

    @Override
    public TransactionModel toModel(Transaction entity) {
        if (entity == null)
            return null;
        else
            return TransactionModel.builder()
                    .amount(entity.getAmount())
                    .description(entity.getDescription())
                    .purpose(entity.getPurpose())
                    .build();
    }
}
