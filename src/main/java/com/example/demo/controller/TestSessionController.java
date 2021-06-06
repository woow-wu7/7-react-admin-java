package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestSessionController {

    @GetMapping("/session")
    public String getSession(
            @RequestParam("username") String username,
            HttpServletRequest request
    ) {
        // 登陆成功后，将用户信息写入session
        // 用户信息写入session后，会将 ( session_id ) 存入 ( cookie )，以后每次请求都会携带cookie，cookie中有 ( JSESSIONID )
        request.getSession().setAttribute("username", username);
        return "服务端session保存成功";
    }

    @GetMapping("/session-test")
    public String getSessionTest(
            @RequestParam("name") String name,
            HttpServletRequest request
    ) {
        request.getSession().setAttribute("name", name);
        return "session-test";
    }
}
