# 7-react-admin-java 
`第一个java服务端项目`  
`用于给 7-react-admin-ts 项目提供server`  

## (1) 技术栈
`SpringBoot + Mybatis + mysql + lombok + devTools`

## (2) 项目过程记录
- [[前端学java01-SpringBoot实战] 环境配置和HelloWorld服务](https://juejin.cn/post/6927306093970325517)
- [[前端学java02-SpringBoot实战] mybatis + mysql 实现歌曲增删改查](https://juejin.cn/post/6929145638898794503)
- [[前端学java03-SpringBoot实战] lombok，日志，部署](https://juejin.cn/post/6930627377101979662)
- [[前端学java04-SpringBoot实战] 静态资源 + 拦截器 + 前后端文件上传](https://juejin.cn/post/6932097247735709709)
- [[前端学java05-SpringBoot实战] 常用注解 + redis实现统计功能](https://juejin.cn/post/6933224825200574478)

## (2) controller层，server层，mapper层，之间的关系
- controller
  - 负责http请求，将参数等信息传递给mapper层接，并将结果返回给客户端
- server
  - 负责处理逻辑
  - 当需要同时处理多个表的关系时，一般都交给sever来组装处理  
- mapper ( DAO )    
  - 负责对数据库增删改查
  
## (3) 部署
- 依赖
  - Git JDK Maven Mysql
- 步骤
- [具体步骤详见我的博客]()




## 资料
[线上预览地址](http://120.53.220.141:81/)    
[我的另一个java项目](https://github.com/woow-wu7/7-community-java)
