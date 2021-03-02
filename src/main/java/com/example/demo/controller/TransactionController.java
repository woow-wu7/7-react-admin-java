package com.example.demo.controller;

import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/addGoods")
    public int addGoods(
            @RequestBody Map body
    ) {
        int res = transactionService.addGoods(body);
        return res;
    }
}
