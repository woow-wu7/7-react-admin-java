package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


// @Value + @Component 可以注册该组件到容器中，并把配置文件application.yml或者application.properties中的变量参数提供给Bean对象
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ValueTestBean {
    private String name;

    private String email;

    @Value("${myapp.author}")
    private String author;
}
