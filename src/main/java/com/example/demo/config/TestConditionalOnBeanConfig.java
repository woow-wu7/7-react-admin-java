package com.example.demo.config;

import com.example.demo.bean.TestConditionalOnBeanBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ConditionalOnBean(name = "com.example.demo.bean.ImportBean") 如果标注在类上，则表示里面所有@Bean生效的前提是容器中有com.example.demo.bean.ImportBean组件
public class TestConditionalOnBeanConfig {

    // @ConditionalOnBean(name) 表示IOC容器中存在 ( name组件 ) 时，才向容器中添加 ( @ConditionalOnBean ) 组件，不存在name就不添加
    // @ConditionalOnBean(name) 如果标注在类上，则表示类里面所有@Bean生效的前提是：容器中有name组件
    // 一般都场景启动器中就有非常多的各种条件注解，条件判断
    // - 在IOC中
      // - 1.优先解析 `@Component，@Service，@Controller，@Mapper`等注解类
      // - 2.再解析配置类，即`@Configuration`标注的类
      // - 3.最后解析配置类中定义的 `@Bean`
    @ConditionalOnBean(name = "com.example.demo.bean.ImportBean")
    @Bean("@ConditionalOnBean")
    public TestConditionalOnBeanBean registerConditionalOnBean() {
        return new TestConditionalOnBeanBean("@ConditionalOnBean");
    }
}
