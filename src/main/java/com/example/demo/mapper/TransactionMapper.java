package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface TransactionMapper {
    // 添加
    public int insertGoods(Map body);
}
