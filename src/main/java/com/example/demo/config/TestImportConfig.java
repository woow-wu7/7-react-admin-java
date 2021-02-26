package com.example.demo.config;

import com.example.demo.bean.TestImportBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// @Import
// 1. @Import 和 @Bean 的作用类似，都是向容器中添加组
// 2. @Import导入容器中的组件名默认是 ( `全类名` )
// 3. 语法：@Import({ 类名.class, 类名.class... })
// 4. 注意点:
//      - @Import()必须用在组件类上，组件肯定是在SpringBootIOC容器中的;
//      - @Import() 比如用在@Config @Controller @Service 等组件上都可以
//      - @Import()可以导入第三方包
@Import({TestImportBean.class})
@Configuration
public class TestImportConfig {
}
