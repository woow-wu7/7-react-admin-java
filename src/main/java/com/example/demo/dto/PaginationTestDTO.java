package com.example.demo.dto;
import com.example.demo.bean.MusicTestBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor // 可以自己实现任意多个参数的有参构造器
@NoArgsConstructor
public class PaginationTestDTO {
    private List<MusicTestBean> music;
    private Integer current;
    private Integer pageSize;
    private Long total;
}
