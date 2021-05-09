package com.example.demo.controller;

import com.example.demo.bean.TestAtBuilderBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAtBuilder {

    @Autowired
    TestAtBuilderBean testAtBuilderBean;

    // 1. 如果使用@Autowired自动注入，则需要在bean对象中添加@Component注解，不然bean会找不到
    @GetMapping("/builder")
    public void testAtBuilder() {
        testAtBuilderBean.builder()
                .china("china")
                .english("english")
                .build();
        System.out.println(testAtBuilderBean);
    }

    // 2. 如果是通过类直接调用 TestAtBuilderBean.builder() 则不需要在bean中添加@Component
    @GetMapping("/builder2")
    public void testAtBuilder2() {
        TestAtBuilderBean testAtBuilderBean = TestAtBuilderBean.builder()
                .china("china")
                .english("english")
                .build();
        System.out.println(testAtBuilderBean);
    }

}
