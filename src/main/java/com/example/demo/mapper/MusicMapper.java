package com.example.demo.mapper;

import com.example.demo.model.MusicModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

// mapper
// 1. mapper文件夹主要是用来映射数据库的相关操作
// 2. 注意：mapper 是 interface
@Mapper
public interface MusicMapper {

    @Select("SELECT * from music limit #{offset},#{pageSize}")
    public List<MusicModel> selectMusics(Integer pageSize, Integer offset); // 查找 - 分页数据

    @Select("SELECT * from music")
    public List<MusicModel> selectAllMusics(); // 查找 - 总数据

    @Insert("insert into music (name, album, singer, startTime, endTime) values (#{name}, #{album}, #{singer}, #{startTime}, #{endTime})")
    int insertMusic(String name, String album, String singer, Date startTime, Date endTime); // 插入
}
