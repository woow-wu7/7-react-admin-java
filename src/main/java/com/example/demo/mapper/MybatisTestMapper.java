package com.example.demo.mapper;

import com.example.demo.bean.MybatisTestBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MybatisTestMapper {
    public MybatisTestBean getMybatisTest(int id);
}
