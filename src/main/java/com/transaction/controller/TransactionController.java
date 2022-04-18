package com.transaction.controller;

import com.transaction.handler.TransactionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionHandler transactionHandler;

    @PostMapping
    public void dosomething() {

    }

    @GetMapping
    public void getSomething() {

    }
}
