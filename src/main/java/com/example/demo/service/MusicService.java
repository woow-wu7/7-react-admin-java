package com.example.demo.service;

//import com.example.demo.dto.PaginationDTO;
import com.example.demo.dto.PaginationDTO;
import com.example.demo.mapper.MusicMapper;
import com.example.demo.model.MusicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

// service
// 1. 主要用于处理获取请求参数后的处理逻辑
// 2. server 是连接 controller 和 mapper(DAO) 的桥梁

@Service
public class MusicService {

    @Autowired
    private MusicMapper musicMapper;

    // 列表
    public PaginationDTO list(Integer pageSize, Integer current) {
        System.out.println(pageSize);
        System.out.println(current);
        Integer offset = pageSize * (current - 1); // 分页的偏移量
        List<MusicModel> musicModels = musicMapper.selectMusics(pageSize, offset); // 分页查询
        List<MusicModel> totalMusics = musicMapper.selectAllMusics(); // 总数据是为了获取 total
        PaginationDTO paginationDTO = new PaginationDTO(); // 这里之所以要new，是因为其他方法中也可能会用到paginationDTO,所以必须不能是单列
        paginationDTO.musics = musicModels;
        paginationDTO.total = totalMusics.toArray().length;
        paginationDTO.current = current;
        paginationDTO.pageSize = pageSize;
        return paginationDTO;
    }

    // 新增
    public Boolean add(String name, String album, String singer) {
        Date startTime = new Date();
        Date endTime = new Date();
        int status = musicMapper.insertMusic(name, album, singer, startTime, endTime);
        if (status > 0) {
            System.out.println("歌曲插入成功");
            return true;
        } else {
            System.out.println("歌曲插入失败");
            return false;
        }
    }
}
