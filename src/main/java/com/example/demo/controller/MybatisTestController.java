package com.example.demo.controller;

import com.example.demo.bean.MybatisTestBean;
import com.example.demo.service.MybatisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisTestController {

    @Autowired
    MybatisTestService mybatisTestService;

    @GetMapping("/mybatis")
    public MybatisTestBean getMybatisTestMessage(@RequestParam(name="id") int id) {
        return mybatisTestService.getMybatisTest(id);
    }
}
