package com.woow.wu7.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestValidationBean { // spring-boot-starter-validation 校验插件测试

    @NotNull(message = "name不能为空") // spring-boot-starter-validation 属性不能为null，但是可以是字符串
    @Size(min = 1, max = 20, message = "name的长度在1-20之间")
    String name;

    @Min(value = 0, message = "年龄必须大于0")
    @Max(value = 150, message = "年龄必须小于150")
    Integer age;

    @AssertTrue(message = "必须是true") // 断言true
    Boolean isTrue;

    @AssertFalse(message = "必须是false")
    Boolean isFalse;

    @Future // 必须是未来的某个时间
    Timestamp future;

    @Past // 必须是过去的某个时间
    Timestamp past;

    @Digits(integer = 2, fraction = 2) // 必须是数字，并且在两位整数和两位小数范围内，即12.1不会报错，但12.123会报错
    Float fl;

    Object score;
    List<String> todo;
}
