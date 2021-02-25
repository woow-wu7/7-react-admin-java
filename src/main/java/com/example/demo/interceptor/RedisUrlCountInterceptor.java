package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interceptor 和 Filter 都具有相同的功能
 * 区别：
 *  1. Filter: 是Servlet定义的原生组件，好处是脱离spring也能使用
 *  2. Interceptor: 是spring定义的接口，只能在spring中使用，可以使用Spring的 ( 自动装配 ) 等功能
 */
@Component // 将拦截器放到容器中
public class RedisUrlCountInterceptor implements HandlerInterceptor {

    @Autowired
    StringRedisTemplate stringRedisTemplate; // 自动注入操作redis的容器中的组件类

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        // stringRedisTemplate.opsForValue().increment(url) => 该方法每次访问该地址，url计数都会+1
        stringRedisTemplate.opsForValue().increment(requestURI);
        return true;
    }

}
