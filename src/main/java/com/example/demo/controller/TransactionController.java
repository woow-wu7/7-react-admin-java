package com.example.demo.controller;

import com.example.demo.bean.TransactionBean;
import com.example.demo.service.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TransactionController {

    @Autowired
    TransactionInterface transactionInterface;

    // 添加
    @PostMapping("/addGoods")
    public int addGoods(
            @RequestBody Map<String, String> body
    ) {
        return transactionInterface.addGoods(body);
    }

    // 查找
    @GetMapping("/getGoods")
    public List<TransactionBean> getGoods() {
        List<TransactionBean> res = transactionInterface.getGoods();
        System.out.println("%%%%%%%%%%%%");
        System.out.println(res);
        return res;
    }
}
