package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@TableName("mybatis_plus_user_bean") // 指定表名，默认情况下mp会将实体名首字母小写，用_连接，作为表名，是mybatis-plus中的注解
public class MybatisPlusUserBean {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(exist = false) // 表示该属性在数据库中不存在，是mybatis-plus中的注解
    private String other;
}
