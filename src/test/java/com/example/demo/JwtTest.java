package com.example.demo;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.demo.bean.JwtUserBean;
import com.example.demo.util.JwtUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
public class JwtTest {

    @Test
    public void object2map() throws JsonProcessingException {
        JwtUserBean jwtUserBean = new JwtUserBean(1, "admin", "admin", "admin"); // bean
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("a", "a");
        stringObjectHashMap.put("b", "b");

        // object => json
        ObjectMapper objectMapper = new ObjectMapper(); // jackson => ObjectMapper
        String s = objectMapper.writeValueAsString(jwtUserBean); // writeValueAsString()
        log.info("object => json: {}", s);

        // map => json
        ObjectMapper objectMapper1 = new ObjectMapper(); // jackson => ObjectMapper
        String s1 = objectMapper1.writeValueAsString(stringObjectHashMap);  // writeValueAsString()
        log.info("map => json: {}", s1);

        // json => object
        ObjectMapper objectMapper3 = new ObjectMapper(); // jackson => ObjectMapper
        JwtUserBean jwtUserBean1 = objectMapper3.readValue(s, JwtUserBean.class);
        log.info("json => object: {}", jwtUserBean1);


        // json => map
        ObjectMapper objectMapper4 = new ObjectMapper(); // jackson => ObjectMapper
        Map map = objectMapper4.readValue(s1, Map.class);
        log.info("json => map: {}", map);

        // object => map
        ObjectMapper objectMapper5 = new ObjectMapper(); // jackson => ObjectMapper
        Map map1 = objectMapper5.convertValue(jwtUserBean, Map.class);
        log.info("object => map: {}", map);
    }

    @Test
    private  Map<String, Object> testToken2() {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        try {
            JwtUtil.verify("\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6ImFkbWluIiwicm9sZXMiOiJhZG1pbiIsImlkIjoiMSIsImV4cCI6MTYyMzU3MTU5MywidXNlcm5hbWUiOiJhZG1pbiJ9.JNME8wbaedF1EYyr9agbTs9pmTxkQ8Iwxh0WJB1Zwig\"");
            // 验证成功
            stringObjectHashMap.put("msg", "请求成功");
            return stringObjectHashMap;
        } catch (SignatureVerificationException e) { // 签名错误
            e.printStackTrace();
        } catch (TokenExpiredException e) { // 过期
            e.printStackTrace();
        } catch (AlgorithmMismatchException e) { // 算法不匹配
            e.printStackTrace();
        } catch (InvalidClaimException e) { // 无效payload
            e.printStackTrace();
        }

        stringObjectHashMap.put("msg", "请求失败");
        return stringObjectHashMap;
    }
}
