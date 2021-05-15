package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("music")
@JsonPropertyOrder(value = {"singer", "album"}) // jackson调整属性顺序，singer在album前面 ------------------ 1
public class MpMusicBean {
    Integer id;

    @JsonIgnore // jackson返回值中不包含该属性，忽略该属性 ---------------------------------------------------- 2
    String name;

    String album;

    @JsonInclude(JsonInclude.Include.NON_NULL) // jackson，包含null，则不返回该字段 -------------------------- 3
    String singer;

    @JsonProperty("start") // jackson修改返回数据的属性名 // ------------------------------------------------- 4
    @TableField(value = "startTime") // value是数据库字段名
    @JsonFormat(pattern = "YYYY-MM-dd") // jackson格式化时间，优先级 ( bean中设置 > 全局配置 ) // --------------- 5
    // 这三个注解的最终效果：将数据库中的startTime列的数据key对应实体的startTime，然后将返回值修改成star，并格式化时间
    Timestamp startTime;

    @TableField(value = "endTime") // value是数据库字段名
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss", timezone = "GMT+8") // jackson格式化时间，优先级 ( bean中设置 > 全局配置 )
    Timestamp endTime;
}
