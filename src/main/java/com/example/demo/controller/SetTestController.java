package com.example.demo.controller;

import com.example.demo.bean.SetTestBean;

// @RestController 注意这里不使用SpringBoot的任何注解，因为是测试spring的set手动注入
// SetTestController 在resources/beans/setTestBeans.xml中配置
public class SetTestController {

    SetTestBean setTestBean;

    public void setSetTestBean(SetTestBean setTestBean) {
        this.setTestBean = setTestBean;
    }

    public String getName2() {
        return setTestBean.getName1();
    }
}
