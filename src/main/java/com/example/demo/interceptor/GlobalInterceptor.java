package com.example.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * 1. 编写一个拦截器，实现 HandlerInterceptor 接口
 * 2. 把拦截器注册到容器中 ( 实现 WebMvcConfigurer 的  addInterceptors 方法)
 * 3. 指定拦截规则 【如果拦截所有，静态资源也会被拦截，可以用 excludePathPatterns 方法放行】
 */
/**
 * 登陆检查
 * @Slf4j
 * 1. @Slf4j 是 lombok 提供的功能
 * 2. @Slf4j 注入后就可以使用 log.info()
 */
@Slf4j
public class GlobalInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle拦截器 - 拦截的路径是{}", request.getRequestURI());
        return true; // true表示放行
        // return false; // false表示不放行
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle拦截器 - ModelAndView", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion拦截器", ex);
    }
}
