package com.example.demo;

import com.example.demo.bean.TestAtBuilderBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AtBuilderTest {

    @Autowired
    TestAtBuilderBean testAtBuilderBean;

    @Test
    void test() {
        testAtBuilderBean.builder()
                .china("中国")
                .english("美国")
                .build();

        log.info("@Builder测试{}", testAtBuilderBean);
    }
}
