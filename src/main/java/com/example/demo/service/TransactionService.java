package com.example.demo.service;

import com.example.demo.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class TransactionService{

    @Autowired
    TransactionMapper transactionMapper;

    @Transactional
    // 事务，如果不加算然报错，但是数据仍会插入数据库
    public int addGoods(Map body) {
        int res = transactionMapper.insertGoods(body);
        int i = 1/0; // 报错
        return res;
    }
}
