package com.example.demo.bean;

import lombok.Data;

// @Data是lombok的注解
@Data
public class MybatisTestBean {
    private String name;
    private int age; // 注意 lang int Integer 三者的区别
    private int id;
}
