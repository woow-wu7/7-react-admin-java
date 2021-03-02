package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// 测试事务对应的表goods
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionBean {
    private String name;
    private BigDecimal price;
    private int id;
}
