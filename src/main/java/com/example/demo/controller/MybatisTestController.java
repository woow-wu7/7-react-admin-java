package com.example.demo.controller;

import com.example.demo.bean.MybatisTestBean;
import com.example.demo.learning.InterfaceImplementsAbstract;
import com.example.demo.service.MybatisTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MybatisTestController {

    @Autowired
    MybatisTestService mybatisTestService;

    InterfaceImplementsAbstract interfaceImplementsAbstract;

    @GetMapping("/mybatis")
    @ResponseBody // 返回 json 数据
    public MybatisTestBean getMybatisTestMessage(@RequestParam(name="id") int id) {
        return mybatisTestService.getMybatisTest(id);
    }

    // 当controller中的api路径和静态资源同名时，访问url，返回的是controller中方法的返回值，而不是静态资源
    // 返回的是 ( 字符串 ) 而不是 ( resources/static/66.jpg 图片 )
    @GetMapping("/66.jpg")
    public String TestStatic() {
        log.info("这个是controller方法执行时机");
        // interfaceImplementsAbstract.smoke(); // 调用实现类
        return "66.jpg";
    }
}
