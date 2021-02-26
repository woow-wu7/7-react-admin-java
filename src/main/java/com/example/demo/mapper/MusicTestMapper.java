package com.example.demo.mapper;

import com.example.demo.bean.MusicTestBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MusicTestMapper {
    // 查
    public List<MusicTestBean> getMusicList(Integer pageSize, Integer offset, String searchKey);

    // total
    public Long getAllMusicList();

    // 增
    public Integer addMusicList(Map<String, Object> body);

    // 删
    public Integer deleteMusic(Integer id);

    public Integer editMusic(Map body);
}
