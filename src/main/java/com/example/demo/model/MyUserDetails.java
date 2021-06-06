//package com.example.demo.model;
//
//import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Component
//public class MyUserDetails implements UserDetails {
//
//    String password;
//    String username;
//
//    boolean accountNonExpired = true; // 是否没过期
//    boolean accountNonLocked = true; // 是否没被锁定
//    boolean credentialsNonExpired = true; // 是否没过期
//    boolean enabled; // 账号是否可用
//    Collection<? extends GrantedAuthority> authorities; // 用户的权限集合
//
////    @Override
////    public Collection<? extends GrantedAuthority> getAuthorities() {
////        return null;
////    }
////
////    @Override
////    public String getPassword() {
////        return password;
////    }
////
////    @Override
////    public String getUsername() {
////        return username;
////    }
////
////    @Override
////    public boolean isAccountNonExpired() {
////        return accountNonExpired;
////    }
////
////    @Override
////    public boolean isAccountNonLocked() {
////        return accountNonLocked;
////    }
////
////    @Override
////    public boolean isCredentialsNonExpired() {
////        return credentialsNonExpired;
////    }
////
////    @Override
////    public boolean isEnabled() {
////        return enabled;
////    }
//}
