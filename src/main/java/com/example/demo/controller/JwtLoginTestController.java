package com.example.demo.controller;

import com.example.demo.service.JwtLoginTestServiceInterface;
import com.example.demo.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class JwtLoginTestController {

    // 如果service是通过实现类实现的接口，这里还是注入interface
    @Autowired
    JwtLoginTestServiceInterface jwtLoginTestServiceInterface;

    @GetMapping("/jwt-login")
    public Object getJwtUser(
            @RequestParam String username,
            @RequestParam String password
    ) {
        HashMap<Object, Object> stringObjectHashMap = new HashMap<>(); // ------------------- 结果map

        Object jwtUser = jwtLoginTestServiceInterface.getJwtUser(username, password); // ---- object，查询数据库返回值
        Map map = new ObjectMapper().convertValue(jwtUser, Map.class); //-------------------- object => map
        String token = JwtUtil.getToken(map); // 生成token
        try {
            stringObjectHashMap.put("msg", "请求成功");
            stringObjectHashMap.put("token", token);
        } catch (Exception e) {
            stringObjectHashMap.put("msg", "请求失败");
            stringObjectHashMap.put("data", e.getMessage());
        }
        return stringObjectHashMap;
    }
}
