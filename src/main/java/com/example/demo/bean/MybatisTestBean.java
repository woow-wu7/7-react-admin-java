package com.example.demo.bean;

import lombok.Data;

// @Data是lombok的注解
@Data
public class MybatisTestBean {
    private String name;
    private int age; // 注意 lang int Integer 三者的区别
    private int id;
    // 1. 注意数据库中是user_id，这要映射成功需要在mybatis-config.xml文件中开启 ( 驼峰命名 )
    // 2. 除了在 ( mybatis-config.xml ) 中配置规则外，其实还可以在 ( application.properties 或 application.yml ) 中配置
    private Integer userId;
}
