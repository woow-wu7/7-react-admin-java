package com.example.demo.learning;

// 将 Smoking 接口的实现类 InterfaceImplementsAbstract 放到 MybatisTestController controller 中执行测试
public class InterfaceImplementsAbstract implements Smoking  {

    @Override
    public void smoke() {
        System.out.println("在实现类中去实现接口中的方法，通过 class 实现类名 implements 接口名");
    }
}
