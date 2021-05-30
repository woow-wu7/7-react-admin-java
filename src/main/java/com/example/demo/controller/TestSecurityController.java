package com.example.demo.controller;

import com.example.demo.service.TestSecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestSecurityController {

    @Autowired
    TestSecurityService testSecurityService;

//    @ResponseBody
//    @GetMapping("/security-test")
//    public TestSecurityBean getUsers(
//            @RequestParam String username,
//            @RequestParam String password
//    ) {
//        log.info("controller-username:{}", username);
//        log.info("controller-password:{}", password);
//        return testSecurityService.getUsersService(username, password);
//    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }


    @GetMapping("/hello") //----------------- 不需要权限即可访问
    public String login() {
        return "hello";
    }


    @GetMapping("/security-admin") // ------- 需要admin角色权限才能访问
    public String getAdmin() {
        return "admin";
    }

    @GetMapping("/security-common") // ------- 需要guest角色权限才能访问
    public String getGuest() {
        return "common";
    }

    @GetMapping("/security-admin-other-method")
    @PreAuthorize(value = "hasAnyRole('admin')") // ------ 这种方法也可以
    public String getAdminByOtherMethod() {
        return "@PreAuthorize(value = \"hasAnyRole('admin')\")";
    }

    @GetMapping("/security-guest-other-method")
    @PreAuthorize(value = "hasAnyRole('guest')") // ------ 这种方法也可以
    public String getGuestByOtherMethod() {
        return "@PreAuthorize(value = \"hasAnyRole('guest')\")";
    }
}
