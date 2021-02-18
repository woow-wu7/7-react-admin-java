package com.example.demo.model;

import lombok.Data;

// model
// model 专门用来做数据库相关的模型对象

// @Data是lombok的注解
// @Data会自动生成 @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor

@Data
public class MusicModel {
    public Integer id;
    public String name;
    public String album;
    public String singer;
    public String startTime;
    public String endTime;
}
