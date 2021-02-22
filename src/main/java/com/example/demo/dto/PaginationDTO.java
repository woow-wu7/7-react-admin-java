package com.example.demo.dto;

import com.example.demo.model.MusicModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// @Data是lombok的注解
// @Data会自动生成 @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
@Data
@AllArgsConstructor // 有参构造器，构造器就是构造函数
@NoArgsConstructor // 无参构造器，构造器就是构造函数
public class PaginationDTO {
    public List<MusicModel> musics;
    public Integer total;
    public Integer current;
    public Integer pageSize;
}
