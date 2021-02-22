package com.example.demo.config;

import com.example.demo.bean.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1. @Configuration 标注的类就是 配置类
 * 2。配置类里，使用 @Bean 标注在方法上给容器注册组件，注册的组件默认也是单实例的
 * 3. 注意：@Configuration标注的类，该类本身也是一个组件，即 MyConfig 也是一个组件，即 ( 配置类本身也是一个组件 )
 *
 * 4. proxyBeanMethods 代理bean的方法
 *    Full(proxyBeanMethods = true) 单例，可以用于 ( 组件依赖 )
 *    Lite(proxyBeanMethods = false)
 */
// 告诉 SpringBoot 这是一个 ( 配置类 )，等用于以前的配置文件
// @Configuration 配置类
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    // @Bean
    // @Bean 给容器中添加组件
    // 1. 以方法名作为组件的id => user1
    // 2. 返回类型就是组件类型 => UserBean
    // 3. 返回的值就是组件在容器中的实例 => new UserBean()
    // @Bean("userX") 的参数可以自定义id
    @Bean("userX")
    public UserBean user1() {
        return new UserBean("woow_wu7", 20);
    }
}
