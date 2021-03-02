package com.example.demo.service;

import com.example.demo.bean.MusicTestBean;
import com.example.demo.bean.StatusBean;
import com.example.demo.dto.PaginationTestDTO;
import com.example.demo.mapper.MusicTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class MusicTestService {


    @Autowired
    MusicTestMapper musicTestMapper;

    @Autowired
    StatusBean statusBean;

    public StatusBean judgeIsSuccess(Integer status) {
        if (status > 0) {
            statusBean.setStatus("success");
        } else {
            statusBean.setStatus("error");
        }
        return statusBean;
    }

    // 查
    public PaginationTestDTO getMusicList(Integer current, Integer pageSize, String searchKey) {
        Integer offset = pageSize * (current - 1); // 偏移量
        List<MusicTestBean> musicList = musicTestMapper.getMusicList(pageSize, offset, searchKey); // List
        Long total = this.getAllMusicLength(); // total

        PaginationTestDTO paginationTestDTO = new PaginationTestDTO(musicList, current, pageSize, total);
        return paginationTestDTO;
    }

    // total
    public Long getAllMusicLength() {
        Long allMusicList = musicTestMapper.getAllMusicList();
        return allMusicList;
    }

    // 增
    public StatusBean addMusicList(Map<String, Object> body) {
        Object startTime = body.get("startTime"); // map.get
        Object endTime = body.get("endTime");
        Timestamp timestampStartTime = Timestamp.valueOf((String) startTime); // ( Timestamp ) 类型对应的是数据库中的 ( datetime ) 类型
        Timestamp timestampEndTime = Timestamp.valueOf((String) endTime); // Timestamp.valueOf(string v) => 将 ( string ) 转成 ( timestamp ) = ( datetime )
        body.put("startTime", timestampStartTime); // map.put
        body.put("endTime", timestampEndTime); // 如果map中key存在，再执行map.put(key)就是更新key对应的value值

        Integer status = musicTestMapper.addMusicList(body);
//        String formatStartTime = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format(startTime);
//        String formatEndTime = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format(endTime);
        return this.judgeIsSuccess(status);
    }

    // 删
    public StatusBean deleteMusic(Integer id) {
        Integer status = musicTestMapper.deleteMusic(id);
        return this.judgeIsSuccess(status);
    }

    public StatusBean editMusic(Map body) {
        Integer status = musicTestMapper.editMusic(body);
        return this.judgeIsSuccess(status);
    }
}
