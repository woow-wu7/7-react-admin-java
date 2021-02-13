package com.example.demo.service;

//import com.example.demo.dto.PaginationDTO;
import com.example.demo.dto.PaginationDTO;
import com.example.demo.mapper.MusicMapper;
import com.example.demo.model.MusicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// server
// 1. 主要用于处理获取请求参数后的处理逻辑
// 2. server 是连接 controller 和 mapper(DAO) 的桥梁

@Service
public class MusicService {

//    @Autowired
//    PaginationDTO paginationDTO;

    @Autowired
    private MusicMapper musicMapper;

    public PaginationDTO list(Integer pageSize, Integer current) {
        System.out.println(pageSize);
        System.out.println(current);

        Integer offset = pageSize * (current - 1);
        List<MusicModel> musicModels = musicMapper.selectMusics(pageSize, offset);
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.musics = musicModels;
        List<MusicModel> total = musicMapper.selectAllMusics();
        paginationDTO.total = total.toArray().length;
        paginationDTO.current = current;
        paginationDTO.pageSize = pageSize;
        return paginationDTO;
    }
}
