package com.transaction.deserialzier;

import com.transaction.domain.Account;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

class AccountCreationTopicDeserializerTest {

    private AccountCreationTopicDeserializer deserializer;

    @BeforeEach
    public void setup() {
        this.deserializer = new AccountCreationTopicDeserializer();
    }

    @Test
    public void givenAccountBytesShouldReturnAccount() {
        JSONObject obj = new JSONObject();
        obj.put("id", 123);
        obj.put("name", "abdus");
        obj.put("email", "abdus@gmail.com");
        byte[] account = obj.toString().getBytes(StandardCharsets.UTF_8);
        Account deserializedAccount = deserializer.deserialize("", account);
        Assertions.assertNotNull(deserializedAccount);
        Assertions.assertEquals(123, deserializedAccount.getId());
        Assertions.assertEquals("abdus", deserializedAccount.getName());
        Assertions.assertEquals("abdus@gmail.com", deserializedAccount.getEmail());
    }

}