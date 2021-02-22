package com.example.demo;

import com.example.demo.bean.UserBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// 主程序类，主配置类
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// 1. 返回 IOC 容器
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

		// 2. 查看容器里的组件
		String[] beanDefinitionNames = run.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			 // System.out.println(name);
		}

		// 3. 从容器中获取组件
		UserBean userX1 = run.getBean("userX", UserBean.class);
		UserBean userX2 = run.getBean("userX", UserBean.class);
		System.out.println("组件：" + (userX1 == userX2));
		System.out.println("上面是true，因为注册的组件默认就是单实例的，因为@Bean给容器注册的组件是单实例的");
	}

}
