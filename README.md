# 7-react-admin-java 
`第一个java服务端项目`  
`用于给 7-react-admin-ts 项目提供server`  

## (1) 技术栈
`SpringBoot + Mybatis + mysql`

## (2) controller层，server层，mapper层，之间的关系
- controller
  - 负责http请求，将参数等信息传递给mapper层接，并将结果返回给客户端
- server
  - 负责处理逻辑
  - 当需要同时处理多个表的关系时，一般都交给sever来组装处理  
- mapper ( DAO )    
  - 负责对数据库增删改查



## 资料
[我的另一个java项目](https://github.com/woow-wu7/7-community-java)
