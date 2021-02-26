package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// @ConfigurationProperties + @Component 实现配置绑定
// @ConfigurationProperties 可以绑定application.properties或者application.yml文件中的变量
// @Component 作用是向容器中添加组件
// 1. 只有在容器中的组件才能获取 SpringBoot 的强大功能，也就是说要使用@ConfigurationProperties()必须用@Component将对象标记成容器组件
// 2. 该 bean 对象主要是测试 @ConfigurationProperties 和 @Component 两个注解
// 3. 如果类中的属性多于application.yml文件中的myapp的话，多的属性返回的是null
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component // 向IOC中添加组件
@ConfigurationProperties(prefix = "myapp") // prefix="myapp" 这个前缀的值是在 application.yml 文件中配置的
public class TestConfigurationPropertiesAndComponentBean {
    private String author;
    private String name;
    private String email;
    private String other; // 因为application.yml文件中myapp配置中没有 other，所以other的值就会是null
}
