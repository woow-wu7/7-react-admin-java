package com.example.demo.mapper;

import com.example.demo.bean.TestSecurityBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestSecurityMapper {
    public TestSecurityBean getUserMessage(String username, String password);
}


