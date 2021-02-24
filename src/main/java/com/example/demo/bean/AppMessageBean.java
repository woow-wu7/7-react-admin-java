package com.example.demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 1. 只有在容器中的组件才能获取 SpringBoot 的强大功能，也就是说要使用@ConfigurationProperties()必须用@Component将对象标记成容器组件
// 2. 该 bean 对象主要是测试 @ConfigurationProperties 和 @Component 两个注解
// 3. 如果类中的属性多于application.yml文件中的myapp的话，多的属性返回的是null
@Data
@Component
@ConfigurationProperties(prefix = "myapp") // prefix="myapp" 这个前缀的值是在 application.yml 文件中配置的
public class AppMessageBean {
    private String name;
    private String email;
    private String author;
    private String other;
}
