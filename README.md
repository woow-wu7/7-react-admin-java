# 7-react-admin-java 
`第一个java服务端项目`  
`用于给 7-react-admin-ts 项目提供server`  

### [pro] [7-react-admin-java-pro](https://github.com/woow-wu7/7-react-admin-java-pro)
### [cloud] [7-spring-cloud](https://github.com/woow-wu7/7-spring-cloud)
### [复习专用] [7-java-spring-boot-server](https://github.com/woow-wu7/7-java-spring-boot-server)

## (1) 技术栈
`SpringBoot + Mybatis + Mybatis-plus + Mysql + Lombok + Jackson + Validation + Swagger + DevTools + Thymeleaf`

## (2) 项目过程记录
- [[前端学java01-SpringBoot实战] 环境配置和HelloWorld服务](https://juejin.cn/post/6927306093970325517)
- [[前端学java02-SpringBoot实战] mybatis + mysql 实现歌曲增删改查](https://juejin.cn/post/6929145638898794503)
- [[前端学java03-SpringBoot实战] lombok，日志，部署](https://juejin.cn/post/6930627377101979662)
- [[前端学java04-SpringBoot实战] 静态资源 + 拦截器 + 前后端文件上传](https://juejin.cn/post/6932097247735709709)
- [[前端学java05-SpringBoot实战] 常用注解 + redis实现统计功能](https://juejin.cn/post/6933224825200574478)
- [[前端学java06-SpringBoot实战] 注入 + Swagger2 3.0 + 单元测试JUnit5](https://juejin.cn/post/6934274450514771982)
- [[前端学java07-SpringBoot实战] IOC扫描器 + 事务 + Jackson](https://juejin.cn/post/6935081135114289188)
- [[前端学java08-SpringBoot实战总结1-7] 阶段性总结](https://juejin.cn/post/6960187616050282533) 
- [[前端学java09-SpringBoot实战] 多模块配置 + Mybatis-plus + 单多模块打包部署](https://juejin.cn/post/6962752749993721892)
- [[前端学java010-SpringBoot实战] bean赋值转换  + 参数校验 + 全局异常处理](https://juejin.cn/post/6965404539298168839)  
- [[前端学java11-SpringSecurity] 配置 + 内存 + 数据库 = 三种方式实现RBAC](https://juejin.cn/post/6968003860522598436)  
- [[前端学java12-SpringSecurity] JWT](https://juejin.cn/post/6970598940479586334)
- [[前端学java13-SpringCloud] Eureka + RestTemplate + Zuul + Ribbon](https://juejin.cn/post/6973100621205520392)

## (2) controller层，server层，mapper层，之间的关系
- controller
  - 负责http请求，将参数等信息传递给mapper层接，并将结果返回给客户端
- server
  - 负责处理逻辑
  - 当需要同时处理多个表的关系时，一般都交给sever来组装处理  
- mapper ( DAO )    
  - 负责对数据库增删改查
  
## (3) 接口api说明
- [development环境 - 需要启动本地项目](http://localhost:7777/swagger-ui/index.html)
- [production环境 - 暂未同步到线上]()
  
## (4) 部署
- 依赖
  - Git JDK Maven Mysql
- 步骤
- [具体步骤详见我的博客]()

## (5) idea 相关插件
- MyBatisX
- Spring Assistant
- Rainbow Brackets 彩虹括号
- Codota AI Autocomplete

## (6) 多模块构建方式即打包部署，请参照
- [[前端学java09-SpringBoot实战] 多模块配置 + Mybatis-plus + 单多模块打包部署](https://juejin.cn/post/6962752749993721892)
- [多模块构建方式即打包部署 - github地址](https://github.com/woow-wu7/7-react-admin-java-pro)


---
---
---

# 7-java-spring-boot-server
[仓库地址] [7-java-spring-boot-server](https://github.com/woow-wu7/7-java-spring-boot-server)

### (1) 相关知识点

```相关知识点

项目初始化
- mac上java安装教程
  - java安装配置：https://juejin.cn/post/6927306093970325517/#heading-15
  - maven安装配置：https://juejin.cn/post/6927306093970325517/#heading-16
  - 注意：如果 maven3.8.5 和 社区版idea 冲突的话，改用 maven3.6.3

打包部署
- 打包 fat-jar
- 打包后的文件：在 target 文件夹中可以找到 jar 包
- 打jar包需要的插件和pom.xml设置：https://juejin.cn/post/6927306093970325517/#heading-13
- 部署相关命令(全)：https://juejin.cn/post/6930627377101979662#heading-11

包结构
  - 注意：SpringBoot项目中，所有的包都必须是 ( 主程序所在的包 ) 的 ( 同级 或者 子级 ) 才会生效
  - 比如：( controller包 ) 就只能放在和 主程序 ( Application ) 所在的包 ( com.example.lingjing ) 的 ( 同一层级 或者 子级 )
  - 问题：如果非要不同一层级或子级怎么设置呢？
  - 回答：@SpringBootApplication(scanBasePackages = "com.example") 来指定更大的范围，这里表示 com.example 下的所有包

配置文件
- 官网说明文档：https://docs.spring.io/spring-boot/docs/current/reference/html/
- application.properties
  - src/main/resources/application.properties
  - src/main/resources/application.yml
- 优先级
  - application.properties > application.yml

pom.xml
- 父项目的作用：请查看pom.xml文件中的 <parent>
- 自定义子项目的版本号： 在当前项目里重写配置，比如：<properties><java.version>1.8</java.version></properties>

插件安装
- lombok
  - 作用：用来简化开发，主要用于自动生成DTO,MODEL，bean对象等的 @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
  - 配置：1. 需要下载idea的lonbok插件 2. 需要在pom.xml中安装lombok的maven依赖
  - 使用：详见 HelloBean 
  - 文章：
    - https://juejin.cn/post/6930627377101979662#heading-9
    - https://juejin.cn/post/6960187616050282533#heading-21
- MyBatisX
  - mybatis的xml文件和mapper类方法间的跳转
- devtools
  - 实现重新构建
  - 快捷键：command + f9 则可以重新构建，不需要在重新run
  - 要实现真正的热更新：https://juejin.cn/post/6960187616050282533#heading-25

SpringBoot常用注解
- @Configuration + @Bean + @Autowired + @Builder
- @ConfigurationProperties + @Compoennt + ( @EnableConfiguraionProperties )
- @Import + @Component + @Bean
- controller相关
  - @GetMapping + @PostMapping ...
  - @RequestParam + @ReqeustBody + @RequestPart + @RequestHeader + @RequestAttribute`
  - @PathVariable + @CookieValue
  - @ResponseBody 详见 UploadController 3 的注释
- 测试相关
  - @SpringBootTest
  - @Test + @RepeatedTest + @DisplayName + @Disabled + @Timeout
  - @BeforeEach + @AfterEach + @BeforeAll + @AfterAll
  - SpringBoot中的单元测试是可以使用SpringBoot的能力的，比如：使用 @Autowired 自动注入bean
- lombock => @Data + @AllArgsConstructor + @NoArgsConstructor + @ToString + @Value +  @Builder + @Slf4j


静态资源访问
- 静态资源目录：在 src/main/resrouces 文件夹下的 ( static ) ( public ) ( resources ) ( META-INF/resources ) 四个文件夹都可以
- 如何访问：通过 `服务地址/静态资源名称` 来访问
- 原理：
  - 结果描述：( 动态资源，比如一个controller的地址是 /a.jpg )，而静态资源文件夹中也有 ( a.jpg )，此时命中的是 controller，而不是静态资源
  - 原因：静态资料匹配 `/**`，也就是说如果 controller 不能处理的情况，才会交给静态资源处理器，都找不到则404
  - 文章：https://juejin.cn/post/6932097247735709709
- 静态资源反问前缀
  - 设置：在 application.yaml 中通过 `spring.mvc.static-path-pattern=/resources/**` 来设置前缀 resoruce
  
数据库相关 ( 分四步 )
- 第一步：pom.xml中安装相关maven
  - spring-boot-starter-jdbc
    - 该场景启动器的主要作用：具有 ( 事务，jdbc，数据源 )
    - 不包含：数据库驱动，因为SpringBoot并不知道我们使用什么数据库，所以需要安装数据库驱动，比如 mysql数据库驱动
  - mysql-connector-java
    - mysql数据库驱动
    - 版本需要和你安装的mysql版本保持一致，即驱动版本和数据库版本要一致
  - mybatis-spring-boot-starter
    - mybatis 操作数据库 
    - mybatis有两种用法：1. 纯注解的方式 2.xml配置的方式
- 第二步：在 application.yaml 中做数据库相关的配置
- 第三步：docker安装mysql
  - 文章：https://juejin.cn/post/6892390655126241287#heading-12
- 第四步：mybatis 访问数据库，并操作数据
  - (安装和配置)文章：https://juejin.cn/post/6929145638898794503/#heading-22
  - idea插件：MyBatisX，可以在 xml 和 类方法 两者中做跳转
  
Swagger
- 作用：自动生成 ( 接口文档 ) 及 ( 自测工具 )，注解以 ( @Api开头 )
- 文章：https://juejin.cn/post/6934274450514771982#heading-3
- 注意：Swagger2 3.0 只需要 ( springfox-boot-starter ) 就可以了 
- 报错--：安装配置好 swagger2 3.0 后报错：Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException
- 解决--：在主程序类上添加 @EnableWebMvc 注解
- 访问--：本地服务地址或者远程服务器地址/swagger-ui/index.html

jackson
- spring-boot-starter-web 场景启动器中已经包含了 jackson
- 如果不使用 spring-boot-starter-web 则自己安装 spring-boot-starter-json
- 文章：https://juejin.cn/post/6935081135114289188#heading-14
- 对比：fastjson + gson + jackson

拦截器 Interceptor
- 步骤
  - 1. implements 实现一个 HandlerInterceptor 拦截类
       - 重写 preHandle 方法
       - 重写 postHandle 方法
       - 重写 afterCompletion 方法
  - 2. implements 实现一个 WebMvcConfigurer 配置类
       - 重写 addInterceptors 方法，在里面添加拦截规则，即 ( 拦截 和 放行 ) 的路径即可

上传文件       
- maven依赖：spring-boot-starter-thymeleaf 返回一个HMTL - web相关
- 文章：https://juejin.cn/post/6932097247735709709#heading-18
- 流程
  - 1. controller的注解：必须是@Controller，而不能是@RestController，因为要返回html
  - 2. controller需要一个 ( 获取上传页面的path ) 和 ( 上传文件的path )
  - 3. 上传文件的参数注解： @RequestPart
  - 4. 上传的文件参数类型： MultipartFile
  - 5. ( html中的input的name属性 - name="single" ) 需要和 (  @RequestPart("single")的参数名 ) 一致，比如都是 single
  - 6. html 放在 src/main/resources/templates 中
- 扩展
  - 问题：如果一个controller，一些页面要返回html，一些又要返回return的内容，怎么办？
  - 等价：如果整个 controller 的注解是 ( @Controller - 返回html )，但是某些方法要 ( 返回数据 ) 怎么办？
  - 回答：
    - @ResponseBody 用在单独的方法上即可返回数据，而不是html
    - 需要用 @Controller注解controller返回html，然后在要返回的return的方法上加上 ( @ResponseBody ) 来返回return后面的内容

配置绑定
  - 1. ( @ConfigurationProperties + @Component -- 作用于Bean对象 ) + ( application.properties中设置属性值 )
  - 2. ( @EnableConfigurationProperties(HelloBean.class) -- 作用于 配置类 ) 只能用在 ( 配置类中 )，即通过 @Configuration 注解修饰的类
  - 案例：查看 HelloBean 和 HelloConfig
  
单元测是
- JUnit5官网：https://junit.org/junit5/docs/current/user-guide/
- 注解：@SpringBootTest
- 详见：src/test/AllTest 类

指定不同环境的配置文件
- 文件
  - application.yml -> 通过 pring.profiles.active 来指定需要加载的配置i文件
  - application-dev.yml
  - application-prod.yml
- 指定方式
  - 1. 配置文件方式：在 aplication.yml 中通过 ( spring.profiles.active = prod ) 来指定配置文件是 ( application-prod.yml )
  - 2. 命令行方式：在打包后，通过命令行来指定
    - java -jar -Dspring.profiles.active=prod target/7-react-admin-java-0.0.1-SNAPSHOT.jar
      - `-Dspring.profiles.active=prod 指定配置文件是 application-prod.yml`
      - 或者 `--spring.profiles.active=prod`

classpath
- 1. 代表的是 src/main/java
- 2. 代表的是 src/main/resources
- 比如：在 application.yml中的 mybatis 的设置 `mapper-locations: classpath:mapper/*.xml`

JWT
- SESSION
  - 案例：详见 SesstionController
  - session的具体认证流程
    - 1.用户提交用户名，密码到服务器
    - 2.服务器认证通过后，在 session 中保存相关数据，比如用户名，角色，登陆时间，等
    - 3.服务器向客户端返回一个 session_id，并写入 cookie
    - 4.客户端以后的每一次请求，都会携带 cookie，即将 session_id 传回服务器
    - 5.服务器收到 session_id，找到之前保存的数据，由此得知用户的身份
  - 参数类型
    - 设置session：-----> HttpSession -> session.setAttribute("name", value)
    - 获取session：-----> HttpServletRequest -> request.getSesion() -> sesstion.getAttribute("name")
- JWT
  - maven依赖：java-jwt
  - JWT：是 json web token 的缩写，( token可以放在cookie或localStorage中，请求是一般放在header中 )
  - 组成：( header头部.payload负载.signature签名 )
  - 文章：https://juejin.cn/post/6970598940479586334#heading-9
  - 详细：
    - 在 JwtTest 中
    - 在 JwtController 中
  - 封装Jwt工具函数
    - 在 src/main/java/com.example.lingjing/utils/JwtUtil 中
``` 

### (2) 快捷键

```快捷键
格式化 -------------------------- command + option + L
参数提示 ------------------------ command + p
打印 --------------------------- sout
删除没有使用到的引入的文件或依赖 ---- control + options + o
Build Project ----------------- command + F9
报错时-更多选项 + 自动生成变量 ---- optiion + enter

全局查找 ------------------------ command + shift + r
文件间跳转 ---------------------- command + e
```


## 资料
[线上预览地址](http://120.53.220.141:81/)    
[我的另一个java项目](https://github.com/woow-wu7/7-community-java)
