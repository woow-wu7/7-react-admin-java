package com.example.demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 只有在容器中的组件才能获取 SpringBoot 的强大功能
// 该 bean 对象主要是测试 @ConfigurationProperties 和 @Component 两个注解
@Data
@Component
@ConfigurationProperties(prefix = "myapp") // prefix="myapp" 这个前缀的值是在 application.yml 文件中配置的
public class AppMessageBean {
    private String name;
    private String email;
    private String author;
}
