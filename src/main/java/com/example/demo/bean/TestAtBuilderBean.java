package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder // @Builder是lombok的注解，用来函数式的链式调用，我们在test中做测试
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TestAtBuilderBean {
    String china;
    String english;
}
