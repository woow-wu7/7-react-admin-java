package com.example.demo.service.impl;

import com.example.demo.bean.JwtUserBean;
import com.example.demo.mapper.JwtLoginTestMapper;
import com.example.demo.service.JwtLoginTestServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtLoginTestServiceImpl implements JwtLoginTestServiceInterface {

    @Autowired
    JwtUserBean jwtUserBean;

    @Autowired
    JwtLoginTestMapper jwtLoginTestMapper;

    public JwtUserBean getJwtUser(String username, String password) {
        return jwtLoginTestMapper.userInfo(username, password);
    }
}
