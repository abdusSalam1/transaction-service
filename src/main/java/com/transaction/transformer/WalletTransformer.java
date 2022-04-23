package com.transaction.transformer;

import com.transaction.domain.Wallet;
import com.transaction.model.WalletModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WalletTransformer implements Transformer<WalletModel, Wallet> {

    private final AccountTransformer accountTransformer;

    @Override
    public Wallet toEntity(WalletModel model) {
        if (model == null)
            return null;
        else
            return Wallet.builder()
                    .account(accountTransformer.toEntity(model.getAccount()))
                    .description(model.getDescription())
                    .purpose(model.getPurpose())
                    .build();
    }

    @Override
    public WalletModel toModel(Wallet entity) {
        if (entity == null)
            return null;
        else
            return WalletModel.builder()
                    .account(accountTransformer.toModel(entity.getAccount()))
                    .description(entity.getDescription())
                    .purpose(entity.getPurpose())
                    .build();
    }
}
