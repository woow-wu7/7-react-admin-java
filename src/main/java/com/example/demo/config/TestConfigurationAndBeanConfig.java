package com.example.demo.config;

import com.example.demo.bean.TestBeanAndConfigurationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration + @Bean 分析在 ( PetConfig 和 UserConfig ) 中
@Configuration
public class TestConfigurationAndBeanConfig {

    @Bean("@ConfigurationAnd@Bean")
    public TestBeanAndConfigurationBean getConfigurationAndBean() {
        return new TestBeanAndConfigurationBean("testBean", "testConfiguration");
    }
}
