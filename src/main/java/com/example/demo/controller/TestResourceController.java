package com.example.demo.controller;

import com.example.demo.bean.TestResourceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ImportResource + @AutoWired 两个都必须要有，一个都不能少
 * @ImportResouce 可以向容器中添加xml中通过bean标签添加到IOC容器中的的组件
 */
@ImportResource("classpath:beans/testResourceBean.xml")
@RestController
public class TestResourceController {

    @Autowired
    TestResourceBean testResourceBean;

    @GetMapping("/@Resource")
    public String getResource() {
        System.out.println("*************");
        System.out.println(testResourceBean.testResource());
        return "测试 => @ImportResource() => @Resource 和 @Autowired 类似";
    }
}
