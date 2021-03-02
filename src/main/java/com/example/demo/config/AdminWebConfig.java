package com.example.demo.config;

import com.example.demo.interceptor.GlobalInterceptor;
import com.example.demo.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器
 * 1. 编写一个拦截器，实现 HandlerInterceptor 接口
 * 2. 把拦截器注册到容器中 ( 实现 WebMvcConfigurer 接口的  addInterceptors 方法)
 * 3. 指定拦截规则 【如果拦截所有，静态资源也会被拦截，可以用 excludePathPatterns 方法放行】
 */
// @Configuration 用于定义 ( 配置类 )

/**
 * @EnableConfigurationProperties(Car.class)
 * 1. 开启 Car 的配置绑定功能
 * 2. 把这个 Car 组件自动注册到容器中
  */
@Configuration
@EnableConfigurationProperties
public class AdminWebConfig implements WebMvcConfigurer {

    // 这里之所以可以自动注入，是因为RedisUrlCountInterceptor类通过@Compoent注册到容器中了，非配置类
    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    // @Override表示被标注的方法是一个重写方法
    // override 覆盖
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 全局拦截器
        registry.addInterceptor(new GlobalInterceptor())
                .addPathPatterns("/**") // 拦截 => 拦截所有请求，包括静态资源
                .excludePathPatterns("/", "/login", "css/**", "/fonts/**", "/images/**", "/js/**"); // 放行，放行了static文件夹下的所有静态资源
                // 问题：如何能访问到 resources/static/images/8.jpg
                // 回答：http://localhost:7777/images/8.jpg

        // redis => 实现访问地址次数统计+1 的拦截器
        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "css/**", "/fonts/**", "/images/**", "/js/**");

    }
}
