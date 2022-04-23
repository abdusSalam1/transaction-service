package com.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionModel {

    private String accountId;
    private String amount;
    private String purpose;
    private String description;
}
