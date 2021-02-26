package com.example.demo.mapper;

import com.example.demo.bean.MybatisTestBean;
import org.apache.ibatis.annotations.Mapper;


@Mapper // 在接口上添加@Mapper注解
public interface MybatisTestMapper {
    public MybatisTestBean getMybatisTest(int id);
}
