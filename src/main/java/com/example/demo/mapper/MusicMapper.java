package com.example.demo.mapper;

import com.example.demo.model.MusicModel;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

// mapper
// 1. mapper文件夹主要是用来映射数据库的相关操作
// 2. 注意：mapper 是 interface
@Mapper
public interface MusicMapper {

    @Select(
            "SELECT * from music where"
                    + " name like CONCAT('%',#{searchKey},'%') or "
                    + " album like CONCAT('%',#{searchKey},'%') or "
                    + " singer like CONCAT('%',#{searchKey},'%')"
                    + " limit #{offset},#{pageSize}"
    )
    public List<MusicModel> selectMusics(Integer pageSize, Integer offset, String searchKey); // 查找 - 分页 + 条件模糊查询

    @Results(value = {
        @Result(column = "name", property = "name"),
        // 主要用来解决 ( 数据库中的column字段 ) 和 ( bean对象中的属性字段 ) 不一致的情况
        // 比如：数据库中叫user_name，而bean对象中叫userName
    })
    @Select("SELECT * from music limit #{offset},#{pageSize}")
    public List<MusicModel> selectMusicsOnlyPagination(Integer pageSize, Integer offset); // 查找 - 分页查询

    @Select("SELECT * from music")
    public List<MusicModel> selectAllMusics(); // 查找 - 总数据

    @Insert("insert into music (name, album, singer, startTime, endTime) values (#{name}, #{album}, #{singer}, #{startTime}, #{endTime})")
    public int insertMusic(String name, String album, String singer, Date startTime, Date endTime); // 插入

    @Update("update music set name=#{name},album=#{album},singer=#{singer},startTime=#{startTime},endTime=#{endTime} where id=#{id}")
    public int editMusic(String name, String album, String singer, Timestamp startTime, Timestamp endTime, int id);

    @Delete("delete from music where id=#{id}")
    public int deleteMusic(int id); // 删除
}
