package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OtherTest {

    @Test
    void test() {
        int a = 10;
        byte b = 20;
        int c = a+b; // 自动转换 => byte + int = int
        byte d = (byte) (a+b); // 强制转换 => a+b的类型是int类型，然后强制转换为byte类型

        double e = 3.14;
        int f = (int) e; // double => int 有可能造成精度丢失，比如这里
        System.out.println(f);
    }
}
