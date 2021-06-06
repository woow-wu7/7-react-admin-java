package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JwtUtil {

    // private 表示只能自己访问，子类和其他类都不能访问
    // static 静态类，表示可以通过类本身来访问
    // final 表示非继承类，不能被其他类继承
    private static final String SIGNATURE = "randomString!";

    // JWT 生成
    // token => header.payload.signature
    public static String getToken(Map<Object, Object> map) {
        // 过期时间设置
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7); // ---------- 过期时间，这里是天为单位，即7天后过期
        JWTCreator.Builder builder = JWT.create(); // ------- jwt
        map.forEach((k, v) -> {
            builder.withClaim(String.valueOf(k), String.valueOf(v)); // ------- jwt payload
        });
        String token = builder
                .withExpiresAt(instance.getTime()) // ------- jwt 过期时间
                .sign(Algorithm.HMAC256(SIGNATURE));// ------ jwt signature
        return token;
    }

    // JWT 验证 + 获取信息
    // 验证token的合法性，并获取token中的信息
    public static DecodedJWT verify(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
        return verify; // 返回 verify 则可以通过 verify.getClaim() 获取到 ( token ) 中存入的 ( payload )
    }
}
