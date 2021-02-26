package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicTestBean {
    private String name; // 歌名
    private String album; // 专辑
    private String singer; // 歌手
    private Integer id;
    private String startTime;
    private String endTime;
}
