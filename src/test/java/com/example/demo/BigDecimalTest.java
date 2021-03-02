package com.example.demo;

import com.example.demo.util.BigDecimalUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
@Slf4j
public class BigDecimalTest {

    @Autowired
    BigDecimalUtil bigDecimalUtil;

    @Test
    void test() {
        double a = 0.1;
        double b = 0.2;
        double c = a + b;
        System.out.println(c);

        // add
        BigDecimal aa = new BigDecimal("1.11");
        BigDecimal bb = new BigDecimal("2.22");
        BigDecimal cc = aa.add(bb);
        log.info("BigDecimal实例add()方法，BigDecimal(String)不会出现精度丢失 => 测试 1.11+2.22={}", cc);

        // divide
        BigDecimal dd = new BigDecimal("30");
        BigDecimal ee = new BigDecimal("7");
        BigDecimal ff = dd.divide(ee, 2, BigDecimal.ROUND_HALF_UP);
        log.info("BigDecimal实例.divide(BigDecimal divisor, int scale, int roundingMode) => 30/7={}", ff);
        log.info("( divisor: 除数 ) , (scale: 保留的小数位数 ) ， (roundingMode: 保留模式，比如四舍五入)");

        // util
        BigDecimal divideUtilRes = bigDecimalUtil.div(30, 7, 2, BigDecimal.ROUND_HALF_UP);
        log.info("divideUtil{}", divideUtilRes);
    }
}
