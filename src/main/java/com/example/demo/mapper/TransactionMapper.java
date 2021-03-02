package com.example.demo.mapper;

import com.example.demo.bean.TransactionBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TransactionMapper {
    // 添加
    public int insertGoods(Map body);

    public List<TransactionBean> getGoods();
}
