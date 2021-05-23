package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestExceptionController {

    @GetMapping("/exception")
    public Object getException() throws Exception {
        if (true) {
            throw new Exception("发生错误了");
        }
        Object obj = new HashMap<>();
        return  obj;
    }
}
