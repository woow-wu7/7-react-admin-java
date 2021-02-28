package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Junit5Test2 {

    int cal(int i, int j) {
        return i + j;
    }

    // (一) 断言：如果前面的断言失败，后面的代码就都不会执行
    @Test
    @DisplayName("测试简单断言 assertions")
    public void testSimpleAssertions() {
        int cal = cal(2, 3);
        // (1) assertEquals => 断言相等
        assertEquals(5, cal, "两个值不相等"); // ( expected期望值 和 actual真实计算的值 ) 是否相等

        // (2) assertSame => 断言是不是同一个对象
        Object obj1 = new Object();
        Object obj2 = obj1;
        assertSame(obj1, obj2, "是不是同i个对象 => 不是同一个对象"); // 第三个参数表示 断言失败后会显示的信息
    }

    @Test
    @DisplayName("测试数组断言1 assertArrayEquals")
    public void testAssertArrayEquals1() {
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2}, "数据内容不相等");
    }

    @Test
    @DisplayName("测试数组断言2 assertArrayEquals")
    public void testAssertArrayEquals2() {
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2}, "数据内容不相等");
    }

    @Test
    @DisplayName("测试组合断言 assertAll")
    public void all() {
        assertAll("test",
                () -> assertTrue(true && true, "不是true"),
                () -> assertEquals(1, 2, "不相等")
        );
        System.out.println("Assertion.assertAll只有断言都成功，该log才会打印");
    }


}
