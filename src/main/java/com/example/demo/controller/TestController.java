package com.example.demo.controller;

import com.example.demo.bean.AppMessageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @Autowired
    AppMessageBean appMessageBean;

    // (1)
    // 测试： @ConfigurationProperties 和 @Component 两个注解
    // 教程： https://www.cnblogs.com/jimoer/p/11374229.html
    @GetMapping("/@ConfigurationProperties")
    public AppMessageBean getAuthorName() {
        System.out.println(appMessageBean);
        String author = appMessageBean.getAuthor();
        System.out.println(author);
        return  appMessageBean;
    }
}
