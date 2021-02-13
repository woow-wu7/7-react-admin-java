package com.example.demo.mapper;

import com.example.demo.model.MusicModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// mapper
// 1. mapper文件夹主要是用来映射数据库的相关操作
// 2. 注意：mapper 是 interface
@Mapper
public interface MusicMapper {

    @Select("SELECT * from music limit #{offset},#{pageSize}")
    public List<MusicModel> selectMusics(Integer pageSize, Integer offset);

    @Select("SELECT * from music")
    public List<MusicModel> selectAllMusics();
}
