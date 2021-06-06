package com.example.demo.service;


// 在 接口interface中不写@Service，而是在interface的实现类implements中写@Service
public interface JwtLoginTestServiceInterface {
    public Object getJwtUser(String username, String password);
}
