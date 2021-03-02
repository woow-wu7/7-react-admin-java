package com.example.demo.config;

import com.example.demo.bean.PetBean;
import com.example.demo.bean.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

// @Configuration
// 1. 对比参考 UserConfig 类
// 2. @Configuration 标注的类是配置类，配置类本身也是组件
// proxyBeanMethods
//      - true 单例
//      - false 不是单例
// 3. 外界无论对配置类中的这个注册方法调用多少次获取的都是之前容器中的单实例，前提是 @Configuration(proxyBeanMethods = true)
// 4. 如果 @Configuration(proxyBeanMethods = false) 外界调用拿到的就不是 ( 代理对象 )，就 ( 不是单实例 ) 的了
// 5. 流程：
//  5-1. 注册：@Configuration + @Bean 向容器中注册组件
//  5-2. 注入：@Autowired 注入类中使用
// 6. @Autowired
//  6-1. @AutoWired 的当前类必须由Spring容器托管，比如通过 @Compoennt @Controller @Service @Mapper @Repository 等标注的组件
//  6-2. 不管是 public 还是 private 修饰的字段都可以自动注入
//  6-3. @AutoWired 的组件必须已经在IOC容器中，不然会找不到报错
//  6-4. 如果当前属性类型在容器中有个多个Bean,那么必须要通过属性名 或者 @Qualifier 指定Bean name


// @Import
// 1. @Import 和 @Bean 的作用类似，都是向容器中添加组
// 2. @Import导入容器中的组件名默认是 ( `全类名` )
// 3. 语法：@Import({ 类名.class, 类名.class... })
// 4. 注意点:
//      - @Import()必须用在组件类上，组件肯定是在SpringBootIOC容器中的;
//      - @Import() 比如用在@Config @Controller @Service 等组件上都可以
//      - @Import()可以导入第三方包

// @ImportResource
// 1. @ImportResource("classpath:beans/beans.xml")
// 2. 参数：`classpath:beans/beans.xml` 表示的是 `配置组件beans.xml的文件路径`
// 3. 具体：`beans.xml` 被放在了 `src/main/resources/beans/beans.xml` 中
// 4. 作用： 导入xml中配置的组件
@Import({UserBean.class, PetBean.class})
@Configuration(proxyBeanMethods = true) // 配置类 => 相当于以前的xml配置文件，xml中有 beans bean 标签
@ImportResource("classpath:beans/beans.xml") // 导入xml中配置的组件
public class PetConfig {

    @Bean // 向容器中注册组件 => @Bean(pet02)这样写可以把注册到容器中的组件重新命名为pet02，而不是用方法名pet01
    public PetBean pet01() {
        return new PetBean("dog", "white");
    }
}
