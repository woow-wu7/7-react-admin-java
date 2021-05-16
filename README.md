# 7-react-admin-java 
`第一个java服务端项目`  
`用于给 7-react-admin-ts 项目提供server`  

## (1) 技术栈
`SpringBoot + Mybatis + Mybatis-plus + Mysql + Lombok + Jackson + DevTools + thymeleaf`

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



## 资料
[线上预览地址](http://120.53.220.141:81/)    
[我的另一个java项目](https://github.com/woow-wu7/7-community-java)
