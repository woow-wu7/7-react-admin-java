package com.example.demo.bean;

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
@TableName("mybatis_plus_user_bean") // 指定表名，默认情况下mp会将实体名首字母小写，用_连接，作为表名
public class MybatisPlusUserBean {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
