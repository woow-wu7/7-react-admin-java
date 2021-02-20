package com.example.demo.service;

//import com.example.demo.dto.PaginationDTO;

import com.example.demo.dto.PaginationDTO;
import com.example.demo.mapper.MusicMapper;
import com.example.demo.model.MusicModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

// service
// 1. 主要用于处理获取请求参数后的处理逻辑
// 2. server 是连接 controller 和 mapper(DAO) 的桥梁

@Service
@Slf4j
public class MusicService {

    @Autowired
    private MusicMapper musicMapper;

    // 逻辑抽离 - 判断操作是否成功，比如添加，删除
    private Boolean judgeIsSuccess(int status) {
        if (status > 0) {
            System.out.println("操作成功");
            log.info("操作成功");
            return true;
        } else {
            System.out.println("操作失败");
            log.error("操作失败");
            return false;
        }
    }

    // 列表
    public PaginationDTO list(Integer pageSize, Integer current, String searchKey) {
        Integer offset = pageSize * (current - 1); // 分页的偏移量
        List<MusicModel> musicModels;
        if (searchKey != null) { // searchKey 是否存在
            musicModels = musicMapper.selectMusics(pageSize, offset, searchKey); // 分页 + 条件
        } else {
            musicModels = musicMapper.selectMusicsOnlyPagination(pageSize, offset); // 分页
        }
        List<MusicModel> totalMusics = musicMapper.selectAllMusics(); // 总数据是为了获取 total
        PaginationDTO paginationDTO = new PaginationDTO(); // 这里之所以要new，是因为其他方法中也可能会用到paginationDTO,所以必须不能是单列
        paginationDTO.musics = musicModels;
        paginationDTO.total = totalMusics.toArray().length;
        paginationDTO.current = current;
        paginationDTO.pageSize = pageSize;
        return paginationDTO;
    }

    // 新增
    @Transactional
    public Boolean add(String name, String album, String singer) {
        Date startTime = new Date(); // 注意：数据库中的data是 ( datetime ) 格式
        Date endTime = new Date();
        int status = musicMapper.insertMusic(name, album, singer, startTime, endTime);
        Boolean aBoolean = judgeIsSuccess(status);
        return aBoolean;
    }

    // 修改
    public Boolean edit(Map<String, Object> body) {
        int id = (int) body.get("id");
        String name = (String) body.get("name");
        String album = (String) body.get("album");
        String singer = (String) body.get("singer");
        Timestamp startTime = Timestamp.valueOf((String) body.get("startTime")); // ( Timestamp ) 类型对应的是数据库中的 ( datetime ) 类型
        Timestamp endTime = Timestamp.valueOf((String) body.get("endTime")); // Timestamp.valueOf(string v) 将string转成timestamp
        int status = musicMapper.editMusic(name, album, singer, startTime, endTime, id);
        Boolean aBoolean = judgeIsSuccess(status);
        return aBoolean;
    }

    // 删除
    public Boolean delete(int id) {
        int status = musicMapper.deleteMusic(id);
        Boolean aBoolean = judgeIsSuccess(status);
        return aBoolean;
    }
}
