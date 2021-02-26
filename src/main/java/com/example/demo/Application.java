package com.example.demo;

import com.example.demo.bean.TestImportBean;
import com.example.demo.bean.PetBean;
import com.example.demo.bean.UserBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// 主程序类，主配置类
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// 1. 返回 IOC 容器
		// 2. IOC的作用是：控制反转 和 依赖注入
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

		// 3. 查看容器里的组件
		String[] beanDefinitionNames = run.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			  System.out.println(name);
		}

		// 3. 从容器中获取组件 userX
		UserBean userX1 = run.getBean("userX", UserBean.class);
		UserBean userX2 = run.getBean("userX", UserBean.class);
		System.out.println("组件：" + (userX1 == userX2));
		System.out.println("上面是true，因为注册的组件默认就是单实例的，因为@Bean给容器注册的组件是单实例的");

		// 3. 从容器中获取组件 pet01
		PetBean pet01 = run.getBean("pet01", PetBean.class);
		System.out.println(pet01.getName()); // 获取pet01对象中的name属性

		// 4. @Import 相关
		String[] beanNamesForType = run.getBeanNamesForType(PetBean.class);
		System.out.println("------------------------------");
		for (String s : beanNamesForType) {
			System.out.println(s);
		}

		// 5. 测试@Import => 向IOC容器添加 ImportBean 组件
		String[] beanNamesForType1 = run.getBeanNamesForType(TestImportBean.class);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		boolean b = run.containsBean("com.example.demo.bean.ImportBean"); // ImportBean
		boolean b1 = run.containsBean("@ConditionalOnBean");
		System.out.println("run.containsBean容器中是否有com.example.demo.bean.ImportBean组件：" + b);
		System.out.println("run.containsBean容器中是否有@ConditionalOnBean件：" + b1);
		for (String s : beanNamesForType1) {
			System.out.println(s);
		}

		// 6
		boolean haha = run.containsBean("haha");
		boolean hehe = run.containsBean("hehe");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("haha:"+haha);
		System.out.println("hehe:"+hehe);
	}
}
