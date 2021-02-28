package com.example.demo.bean;


public class TestResourceBean {
    public String testResource() {
        System.out.println("测试 @Resource");
        System.out.println("@Resource 和 @Autowired 类似");
        return "@Resource 和 @Autowired 类似";
    }
}
