package com.example.demo.service.impl;

import com.example.demo.bean.TransactionBean;
import com.example.demo.mapper.TransactionMapper;
import com.example.demo.service.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

// 回滚
// 1. 数据库 ( 回滚 ) 的概念
// 在事务运行过程中，发生了某种故障，事务不能继续执行，系统将事务中对数据库的所有已完成的操作全部撤销，滚回到事务开始时的状态
@Service
@Transactional
public class TransactionService implements TransactionInterface {

    @Autowired
    TransactionMapper transactionMapper;

    // 增
    // 事务
    // 事务，如果不加算然报错，但是数据仍会插入数据库
    // 事务注解 @Transactional 可以加在类的方法上，也可以加载类上，加在类上相当于加在所有方法上
    // @Transactional
    public int addGoods(Map body) {
        int res = transactionMapper.insertGoods(body);
        int i = 1/0; // 报错，因为 0 不能作为除数，抛错后事务就会回滚
        return res;
    }

    // 查
    public List<TransactionBean> getGoods() {
        List<TransactionBean> res = transactionMapper.getGoods();
        return res;
    }
}
