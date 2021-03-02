package com.example.demo.service;


import com.example.demo.bean.TransactionBean;

import java.util.List;
import java.util.Map;

public interface TransactionInterface {
    public  int addGoods(Map body);

    public List<TransactionBean> getGoods();
}
