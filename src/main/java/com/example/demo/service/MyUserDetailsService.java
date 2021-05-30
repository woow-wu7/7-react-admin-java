package com.example.demo.service;

import com.example.demo.mapper.MyUserDetailsServiceMapper;
import com.example.demo.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    MyUserDetailsServiceMapper myUserDetailsServiceMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // s 表示登陆时传入的唯一标识，不一定是用户名

        // 1 用户基础数据加载
        MyUserDetails myUserDetails = myUserDetailsServiceMapper.findByUserName(s);
        if (myUserDetails == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 2 加载用户的角色列表
        List<String> roleCodes = myUserDetailsServiceMapper.findRoleByUserName(s);

        // 3 根据角色列表加载当用用户具有的权限
        List<String> authorities = myUserDetailsServiceMapper.findAuthorityByRoleCodes(roleCodes);

        roleCodes = roleCodes.stream()
                .map(rc -> "ROLE_" + rc)
                .collect(Collectors.toList());

        authorities.addAll(roleCodes);

        myUserDetails.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(
                String.join(",", authorities)
        ));

        return myUserDetails;
    }
}
