package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestStaticResources {

    // 静态资源

    // 1
    // - resources/static
    // - resources/public
    // - resources/MATA-INF/resources
    // - resources/resources
    // - 以上四个文件夹中的文件就属于静态资源，通过访问 `跟路径/静态资源名称` 即可

    // 2
    // 原理：静态映射 /**
    // 请求进来，先去 ( controller ) 中看能不能处理，如果不能处理再交给 ( 静态资源处理器去处理静态资源 )

    // 3
    // 问题：如果controller中有一个接口/mm.jpg，而我们的静态资源文件夹中同样有一个静态资源叫mm.jpg，会发生什么？
    // 答案：会优先处理controller中的类，而不会去访问静态资源

    // 4
    // 静态资源前缀
    // 静态资源设置前缀：spring.mvc.static-path-pattern=/resources/**
    // 访问静态资源：当前项目 + 前缀 + 静态资源
    // 例子：http://localhost:7777/resources/66.jpg

    // 5
    // 指定自定义的静态资源目录 ( 默认静态文件夹路径 )
    // spring.web.resources.static-locations=[classpath:/7resources/]
    @GetMapping("/mm.jpg")
    public String getStaticResources() {
        return "string, is not static resource mm.jpg";
    }
}
