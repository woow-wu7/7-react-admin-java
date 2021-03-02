package com.example.demo.bean;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 注意：
// 1. 如果加了 ( 有参构造器 ) 则 ( 一定要加无参构造 )
// 2. 只加 ( 无参构造器 )，则不需要 ( 有参构造器 )
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("歌曲") // swagger的注解
@JsonPropertyOrder(value = {"singer", "name"}) // jackson的注解，改变属性的属性，让singer排在name前
public class MusicTestBean {

    @ApiModelProperty(name = "name", value = "歌名") // swagger的注解，加名字让人更容器理解，和一些说明
    @JsonProperty("musicName") // jackson的注解，修改属性的名字，注意：这里不会影响 @JsonPropertyOrder
    private String name; // 歌名

    @ApiModelProperty(name = "album", value = "专辑")
    private String album; // 专辑

    @ApiModelProperty(name = "singer", value = "歌手")
    private String singer; // 歌手

    @JsonIgnore // jackson的注解，忽略该属性，即不返回该字段
    private Integer id;

    @JsonFormat(pattern = "YYYY-MM-DD HH:dd:ss", timezone = "GMT+8") // jackson的注解，将日期格式化成这样的形式
    private Date startTime;

    @JsonInclude(JsonInclude.Include.NON_NULL) // jackson的注解，如果是null，则不返回该字段
    private String endTime;
}
