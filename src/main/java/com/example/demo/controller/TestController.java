package com.example.demo.controller;

import com.example.demo.bean.AppMessageBean;
import com.example.demo.bean.TestConfigurationPropertiesAndComponentBean;
import com.example.demo.bean.ValueTestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class TestController {

    @Autowired
    AppMessageBean appMessageBean;

    @Autowired
    ValueTestBean valueTestBean;

    @Autowired
    TestConfigurationPropertiesAndComponentBean testConfigurationPropertiesAndComponentBean;

    // (1)
    // 测试： @ConfigurationProperties 和 @Component 两个注解
    // 教程： https://www.cnblogs.com/jimoer/p/11374229.html
    @GetMapping("/@ConfigurationProperties")
    public AppMessageBean getAuthorName() {
        System.out.println(appMessageBean);
        String author = appMessageBean.getAuthor();
        System.out.println(author);
        return appMessageBean;
    }

    // (2)
    // 测试：@Value + @Component
    // 1. 和 ValueTestBean 关联
    // 2. 变量参数在 application.yml 文件中
    @GetMapping("/@Value")
    public ValueTestBean getValueAuthorName() {
        System.out.println(valueTestBean);
        String author = valueTestBean.getAuthor();
        System.out.println(author);
        return valueTestBean;
    }

    // 测试 request
    // 测试 @PathVariable
    // 测试 @CookieValue
    // 测试 @RequestHeader => 对比 @RequestParam @RequestBody @RequestPart
    // 测试 @RequestAttribute
    // 测试 @RequestParam
    // 测试 @RequestBody
    // 测试URL：http://localhost:7777/car/1/owner/woow_wu7?age=20&city=chongqing
    @GetMapping("/car/{id}/owner/{username}")
    public Void getPath(
            HttpServletRequest request,
            @PathVariable("id") int id,
            @PathVariable("username") String username,
            @PathVariable Map<String, String> pathVariable,
            // @CookieValue("name") String name,
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader Map<String, String> headers,
            @RequestParam("age") int age,
            @RequestParam Map<String, String> params
            // @RequestBody String body
            // @RequestAttribute("message") String message
    ) {
        log.info("@PathVariable('id') => id:{}, username: {}", id, username);
        log.info("@PathVariable Map<String, String> => 可以用一个map对象，接收所有的path变量 => pv: {}", pathVariable);
        String tempId = pathVariable.get("id"); // Map实例有 ( map.get ) ( map.put ) 等方法
        System.out.println(tempId);

        log.info("@RequestHeader('User-Agent') => User-Agent: {}", userAgent);
        log.info("@RequestHeader Map<String, String> => headers: {}", headers);

        log.info("@RequestParam Map<String, String> => params: {}", params);
        // log.info("@CookieValue('name') => name: {}", name);
        // log.info("@RequestBody String body => 可以获取post请求的body，也可以是一个Map实例，比如 @RequestBody Map<String, Object> body ====> body{}", body);

        request.setAttribute("message", "success");
        log.info("request: {}", request.getAttribute("message"));
        return null;
    }

    // 测试URL:
    @GetMapping("/car/sell")
    public Map carSell(
            @MatrixVariable("low") Integer low,
            @MatrixVariable("brand") List<String> brand
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        return map;
    }

    // 用来测试默认的 SpringBoot 的错误处理
    // src/main/resources/templates/error/404.html 5xx.html
    @GetMapping("/error")
    public Error getError() {
        return new Error();
    }

    // 基本数据类型
    @GetMapping("/baseData")
    public static Map getLog() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("byte", Byte.SIZE);
        map.put("minByte", Byte.MIN_VALUE);
        map.put("maxByte", Byte.MAX_VALUE);
        map.put("byteType", Byte.TYPE);
        map.put("short", Short.SIZE);
        map.put("minShort", Short.MIN_VALUE);
        map.put("maxShort", Short.MAX_VALUE);
        map.put("shortType", Short.TYPE);
        map.put("int", Integer.SIZE);
        map.put("minInt", Integer.MIN_VALUE);
        map.put("maxInt", Integer.MAX_VALUE);
        map.put("intType", Integer.TYPE);
        map.put("long", Long.SIZE);
        map.put("minLong", Long.MIN_VALUE);
        map.put("maxLong", Long.MAX_VALUE);
        map.put("longType", Long.TYPE);
        final int i =128;
        byte b = (byte)i;
        System.out.println("0000000000000000000000");
        System.out.println(b);
        return map;
    }

    @GetMapping("/testArrayAndList")
    public static Void testArrayAndList() {
        List myList = new ArrayList();
        ArrayList myList2 = new ArrayList();
        return null;
    }

    @GetMapping("/@ConfigurationPropertiesAnd@Component")
    public TestConfigurationPropertiesAndComponentBean testConfigurationPropertiesAndComponentBean() {
        return testConfigurationPropertiesAndComponentBean;
    }
}


