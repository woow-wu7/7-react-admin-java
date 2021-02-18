package com.example.demo.dto;

import com.example.demo.model.MusicModel;
import lombok.Data;

import java.util.List;

// @Data是lombok的注解
// @Data会自动生成 @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
@Data
public class PaginationDTO {
    public List<MusicModel> musics;
    public Integer total;
    public Integer current;
    public Integer pageSize;
}
