package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@Slf4j
public class DateTest {

    @Test
    void testDate() {
        Date date = new Date(); // 获取时间实例
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); // 生成实例
        String format = dateFormat.format(date); // 调用实例实例上的format()方法，返回一个字符串
        log.info("SimpleDateFormat: {}", format);
    }
}
