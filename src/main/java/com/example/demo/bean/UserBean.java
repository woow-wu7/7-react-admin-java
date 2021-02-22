package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 有参构造器，构造器就是构造函数
@NoArgsConstructor // 无参构造器，构造器就是构造函数
public class UserBean {
    private String name;
    private Integer age;
}
