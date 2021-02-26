package com.example.demo.controller;

import com.example.demo.bean.StatusBean;
import com.example.demo.dto.PaginationTestDTO;
import com.example.demo.service.MusicTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MusicTestController {

    @Autowired
    MusicTestService musicTestService;

    // 查
    @GetMapping("/getMusicListTest")
    public PaginationTestDTO getMusicList(
            @RequestParam(value = "name", defaultValue = "1") Integer current,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "searchKey", defaultValue = "") String searchKey
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
