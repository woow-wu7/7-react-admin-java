package com.example.demo;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @SpringBootTest 是下面这些注解的复合注解
 *    @BootstrapWith(SpringBootTestContextBootstrapper.class)
 *    @ExtendWith(SpringExtension.class) =>  @ExtendWith
 */
@SpringBootTest
@DisplayName("JUnit5功能测试")
public class Junit5Test {

    @DisplayName("测试方法1 @DisplayName 注解")
    public void testDisplayName1() {
        System.out.println("@DisplayName1");
    }

    @DisplayName("测试方法2 @DisplayName 注解")
    public void testDisplayName2() {
        System.out.println("@DisplayName2");
    }

    @Disabled // 禁用
    @DisplayName("测试方法 @Disabled 注解")
    public void testDisabled() {
        System.out.println("@Disabled");
    }

    @RepeatedTest(5) // 重复测试5次
    @DisplayName("测试方法 @RepeatedTest 注解")
    public void testRepeatedTest() {
        System.out.println("@RepeatedTest -----5");
    }

    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS) // 超出时间报错
    public void testTimeout() throws InterruptedException {
        Thread.sleep(1200);
        System.out.println("@Timeout");
    }

    @BeforeEach
    public void testBeforeEach() {
        System.out.println("@BeforeEach");
    }

    @AfterEach
    public void testAfterEach() {
        System.out.println("@AfterEach");
    }

    @BeforeAll
    static public void testBeforeAll() {
        // 注意: @BeforeAll 和 @AfterAl 标注的方法必须是 ( 静态方法 )
        System.out.println("@BeforeAll");
    }

    @AfterAll
    static public void testAfterAll() {
        System.out.println("@AfterAll");
    }
}
