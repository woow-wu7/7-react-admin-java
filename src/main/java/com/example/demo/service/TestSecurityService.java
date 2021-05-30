package com.example.demo.service;

import com.example.demo.bean.TestSecurityBean;
import com.example.demo.mapper.TestSecurityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestSecurityService implements UserDetailsService {

    @Autowired
    TestSecurityMapper testSecurityMapper;

    public TestSecurityBean getUsersService(String username, String password) {
        log.info("service-username=>{}", username);
        log.info("service-password=>{}", password);
        return testSecurityMapper.getUserMessage(username, password);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
