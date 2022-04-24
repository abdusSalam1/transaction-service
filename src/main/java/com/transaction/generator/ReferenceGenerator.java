package com.transaction.generator;

public interface ReferenceGenerator {

    default String generateReference() {
        return generateReference("");
    }

    String generateReference(String prefix);

    String generateReference(String prefix, int extraCharLength);
}
