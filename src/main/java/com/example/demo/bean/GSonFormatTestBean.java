package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

// GSonFormat插件
// 快捷键：alt + s
@NoArgsConstructor
@Data
public class GSonFormatTestBean {

    /**
     * name : 公交车
     * price : 1000
     * id : 1
     */

    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("id")
    private Integer id;
}
