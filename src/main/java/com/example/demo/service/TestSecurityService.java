package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestSecurityService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("+++++++++{}", username);
        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("只能用admin登陆");
        }
        String password = new BCryptPasswordEncoder().encode("admin");

        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,guest"));
    }
}
