package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Controller 可以返回html页面
 * @RestController 不能返回html页面，返回的内容就是return的内容
 * 1. @RestController = @Controller + @ResponseBody
 * 2. 如果一个controller，一些页面要返回html，一些又要返回return的内容，就需要用 @Controller注解controller返回html，然后在要返回的return的方法上加上@ResponseBody来返回return后面的内容
 */
//@RestController
@Controller
@Slf4j
public class FileUpload {

    // (1)
    // 前后端未分离的上传页面
    @GetMapping("/fileUpload")
    public String handleFile(
    ) {
        // 1. 这里返回的是 resources/templates/fileUpload.html
        // 2. 需要安装 spring-boot-starter-thymeleaf 这个maven依赖
        return "fileUpload";
    }

    // (2)
    // 前后端未分离的 上传接口
    // MultipartFile 会自动封装上传上来的文件
    @PostMapping("/upload")
    public String upload(
            @RequestPart("single") MultipartFile single,
            @RequestPart("multiple") MultipartFile[] multiple
    ) throws IOException {
        log.info("上传的单文件{}", single);
        log.info("上传的多文件{}", multiple);
        if (!single.isEmpty()) {
            String originalFilename = single.getOriginalFilename(); // 获取原始文件名
            // 1. single.transferTo() 将single文件转存到...
            // 2. 保存到 ( F/java-workspace/uploadFolder ) 文件夹
            single.transferTo(new File("F:\\Java-workspace\\uploadFolder\\" + originalFilename));
        }
        if (multiple.length > 0) {
            for (MultipartFile file : multiple) { // for循环
                if (!file.isEmpty()) {
                    String originalFilename = file.getOriginalFilename(); // 原始文件名
                    long size = file.getSize() / 1024; // 文件大小，默认但是为字节，1MB = 1024KB = 1024 * 1024 byte
                    log.info("文件名{}. 大小{}KB", originalFilename, size);
                    file.transferTo(new File("F:\\Java-workspace\\uploadFolder\\" + originalFilename));
                }
            }
        }
        return "fileUpload"; // 返回 fileUpload.html
    }

    // (3)
    // 前后端分离的接口
    // 注意点
    // 1. consumes 一定要设置成 "multipart/form-data" 因为前端 antd 中的 Upload 组件是用的 form-data 方式在上传
    // 2. 前端上传时 Upload 组件一定要设置 name 属性，因为 name 的值是和这里的 @RequestPart("前端name属性的值") 一一对应
    // 3. consume 是消费的意思
    @PostMapping(value = "/frontendUpload", consumes = "multipart/form-data")
    @ResponseBody
    public String frontendUpload(
            // @RequestParam("file") MultipartFile avatars
            @RequestPart("file") MultipartFile avatars
    ) {
        System.out.println(avatars);
        return "上传成功";
    }
}
