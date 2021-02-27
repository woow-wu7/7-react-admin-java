package com.example.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 注意：
// 1. 如果加了 ( 有参构造器 ) 则 ( 一定要加无参构造 )
// 2. 只加 ( 无参构造器 )，则不需要 ( 有参构造器 )
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("歌曲")
public class MusicTestBean {
    @ApiModelProperty(name = "name", value = "歌名")
    private String name; // 歌名

    @ApiModelProperty(name = "album", value = "专辑")
    private String album; // 专辑

    @ApiModelProperty(name = "singer", value = "歌手")
    private String singer; // 歌手

    private Integer id;
    private String startTime;
    private String endTime;
}
