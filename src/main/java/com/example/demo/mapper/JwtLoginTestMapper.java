package com.example.demo.mapper;

import com.example.demo.bean.JwtUserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper // mapper一定是一个interface
public interface JwtLoginTestMapper {

    @Select(
            "SELECT * from user where username= #{username} and  password= #{password}"
    )
    public abstract JwtUserBean userInfo(String username, String password); // abstract抽象类，不用写实现
}
