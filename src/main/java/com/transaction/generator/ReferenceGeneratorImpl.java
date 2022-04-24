package com.transaction.generator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class ReferenceGeneratorImpl implements ReferenceGenerator {

    @Override
    public String generateReference(String prefix) {
        // 36 - prefix length because UUID was generally previously used and has 36 chars
        return String.format("%s%s", prefix, RandomStringUtils.randomAlphanumeric(36 - prefix.length()));
    }

    @Override
    public String generateReference(String prefix, int extraCharLength){
        if(extraCharLength < 1)
            return prefix;
        return String.format("%s%s", prefix, RandomStringUtils.randomAlphanumeric(extraCharLength));
    }

}
