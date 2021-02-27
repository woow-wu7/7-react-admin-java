package com.example.demo.controller;

import com.example.demo.bean.StatusBean;
import com.example.demo.dto.PaginationTestDTO;
import com.example.demo.service.MusicTestService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
// @Api(tags = "crud歌曲信息") 默认值是controller下的文件名
public class MusicTestController {

    @Autowired
    MusicTestService musicTestService;

    // 查
    @GetMapping("/getMusicListTest")
    @ApiOperation(value = "查询歌曲列表") // Swagger2
    public PaginationTestDTO getMusicList(
            @RequestParam(value = "current", defaultValue = "1")
                @ApiParam(name = "current", value = "当前页", defaultValue = "1", required = false) Integer current,
            @RequestParam(value = "pageSize", defaultValue = "10")
                @ApiParam(name = "pageSize", value = "每页数量", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "searchKey", defaultValue = "")
                @ApiParam(name = "searchKey", value = "搜索框", defaultValue = "", required = false) String searchKey
    ) {
        return musicTestService.getMusicList(current, pageSize, searchKey);
    }

    // 增
    @PostMapping("/addMusicTest")
    public StatusBean addMusic(
            @RequestBody Map<String, Object> body
    ) {
        return musicTestService.addMusicList(body);
    }

    // 删
    @PostMapping("/deleteMusicTest")
    public StatusBean deleteMusic(
            @RequestBody Map body
    ) {
        Integer id = (Integer) body.get("id");
        return musicTestService.deleteMusic(id);
    }

    // 改
    @PostMapping("/editMusicTest")
    public StatusBean editMusic(
            @RequestBody Map body
    ) {
        return musicTestService.editMusic(body);
    }
}
