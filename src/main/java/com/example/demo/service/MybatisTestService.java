package com.example.demo.service;

import com.example.demo.bean.MybatisTestBean;
import com.example.demo.mapper.MybatisTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MybatisTestService {

    @Autowired
    MybatisTestMapper mybatisTestMapper;

    public MybatisTestBean getMybatisTest(int id) {
        System.out.println(id);
        return mybatisTestMapper.getMybatisTest(id);
    }
}
