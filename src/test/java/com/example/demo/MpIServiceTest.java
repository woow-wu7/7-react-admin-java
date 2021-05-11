package com.example.demo;

import com.example.demo.bean.MybatisPlusUserBean;
import com.example.demo.service.MpIService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MpIServiceTest {

    @Autowired
    MpIService mpIService;

    @Test
    void mpIServiceTest() {
        List<MybatisPlusUserBean> data = mpIService.list();
        log.info("{}", data);
    }
}
