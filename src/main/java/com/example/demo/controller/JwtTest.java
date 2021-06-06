package com.example.demo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@RestController
@Slf4j
public class JwtTest {
    @GetMapping("/jwt-test")
    public void testJwt() throws ParseException {

        // 完整案例请查看 JwtLoginTestController 和 JwtUtil

        // 1. JWT加密
        HashMap<String, Object> HeaderMap = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 2000); // 2000s 过期
        String token = JWT.create() // 生成jwt
                .withHeader(HeaderMap) // header
                .withClaim("username", "woow_wu7") // ------ payload
                .withClaim("age", 20) // ------------------- payload
                .withExpiresAt(instance.getTime()) // 过期时间
                .sign(Algorithm.HMAC256("secretXx"));// ---------------- signature 签名    (algorithm是算法的意思)
        log.info("token: {}", token);


        // 2. JWT验证
        // secretXx 生成验证对象
        // 注意：Algorithm.HMAC256() 的参数就是上面生成jwt时 ( 签名 ) 时传入的签名字符串
        JWTVerifier secretXx = JWT.require(Algorithm.HMAC384("secretXx")).build();
        DecodedJWT verify = secretXx.verify(token);
        String username = verify.getClaim("username").asString(); // 获取username，注意过期时间，过期后是拿不到username的
        Integer age = verify.getClaim("age").asInt();
        log.info("传入token，验证token中的username:{}", username);
        log.info("传入token，验证token中的age:{}", age); // 这种方式age会是null，下面的写法才能拿到age

        Date expiresAt = verify.getExpiresAt();
        log.info("token的过期时间:{}", expiresAt); // 这种方式age会是null，下面的写法才能拿到age


//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date date = dateFormat.parse("2020-02-02 02:20:20");
//        String format = dateFormat.format(date);
//        log.info("format{}", format);
//
//        String parse2 = dateFormat.format(new Date());
//        log.info("parse2{}", parse2);
//
//
//        Calendar instance = Calendar.getInstance();
//        instance.setTime(date);
//        Date time = instance.getTime();
//        log.info("time{}", time);
    }
}
