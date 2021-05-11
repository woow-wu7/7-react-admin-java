package com.example.demo;

import com.example.demo.bean.MybatisPlusUserBean;
import com.example.demo.mapper.MybatisPlusUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MybatisPlusUserTest {

    @Autowired
    MybatisPlusUserMapper mybatisPlusUserMapper;

    // mapper相关测试
    // 查询
    @Test
    void getUser() {
        MybatisPlusUserBean user = mybatisPlusUserMapper.selectById(1);
        log.info("用户信息{}", user);
    }

    // mapper相关测试
    // 添加
    @Test
    void addUser() {
        MybatisPlusUserBean user = new MybatisPlusUserBean();
        long a = 11;
        MybatisPlusUserBean user2  = user.builder()
                .name("周杰伦2")
                .age(200)
                .email("woow.wu7@gmail.com")
                .id(a)
                .build();

        int status = mybatisPlusUserMapper.insert(user2);
        log.info("Mybatis-plus插入insert()方法的返回值{}", status);
    }

    // mapper相关测试
    // 删除
    @Test
    void deleteUser() {
        int id = 11;
        int status = mybatisPlusUserMapper.deleteById(id);
    }

    // mapper相关测试
    // 更新
    @Test
    void editUser() {
        MybatisPlusUserBean user = new MybatisPlusUserBean();
        long userId = 11;
        MybatisPlusUserBean user2  = user.builder()
                .name("周杰伦13000")
                .age(3000)
                .email("woow.wu3000@gmail.com")
                .id(userId)
                .build();
        int status = mybatisPlusUserMapper.updateById(user2);
    }
}
