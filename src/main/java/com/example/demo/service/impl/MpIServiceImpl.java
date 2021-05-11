package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.bean.MybatisPlusUserBean;
import com.example.demo.mapper.MybatisPlusUserMapper;
import com.example.demo.service.MpIService;
import org.springframework.stereotype.Service;

@Service
public class MpIServiceImpl extends ServiceImpl<MybatisPlusUserMapper, MybatisPlusUserBean> implements MpIService {
}
