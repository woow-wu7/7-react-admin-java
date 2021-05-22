package com.example.demo.controller;

import com.woow.wu7.bean.TestValidationBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@Slf4j
public class TestValidationController {

    @PostMapping("/test-validation")
    public Object getValidation(
            // @Validated // spring-boot-start-validation
            @Valid // spring-boot-start-validation
            @RequestBody TestValidationBean testValidation,
            BindingResult bindingResult, // 如果不加 BindingResult则无法返回bean中指定的message
            HttpServletResponse httpServletResponse // 用来修改返回报文中的状态码等
    ) {
        if (bindingResult.hasErrors()) {
            httpServletResponse.setStatus(412); // 设置返回的状态码
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return testValidation;
    }
}
