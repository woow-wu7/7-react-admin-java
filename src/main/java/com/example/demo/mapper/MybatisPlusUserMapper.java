package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.MybatisPlusUserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MybatisPlusUserMapper extends BaseMapper<MybatisPlusUserBean> {
}
