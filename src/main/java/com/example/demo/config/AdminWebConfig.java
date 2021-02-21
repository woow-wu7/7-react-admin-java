package com.example.demo.config;

import com.example.demo.interceptor.GlobalInterceptor;
import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器
 * 1. 编写一个拦截器，实现 HandlerInterceptor 接口
 * 2. 把拦截器注册到容器中 ( 实现 WebMvcConfigurer 的  addInterceptors 方法)
 * 3. 指定拦截规则 【如果拦截所有，静态资源也会被拦截，可以用 excludePathPatterns 方法放行】
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GlobalInterceptor())
                .addPathPatterns("/**") // 拦截 => 拦截所有请求，包括静态资源
                .excludePathPatterns("/", "/login", "css/**", "/fonts/**", "/images/**", "/js/**"); // 放行，放行了static文件夹下的所有静态资源
                // 问题：如何能访问到 resources/static/images/8.jpg
                // 回答：http://localhost:7777/images/8.jpg
    }
}
