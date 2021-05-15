package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bean.MpMusicBean;
import com.example.demo.service.MpMusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class MpMusicController {

    @Autowired
    MpMusicService mpMusicService;


    @GetMapping("/mp-music-list")
    public List<MpMusicBean> getMusic() {
        return mpMusicService.list();
    }

    @GetMapping("/mp-music-page")
    public Object getPages(
            @RequestParam(value = "current", defaultValue = "1") Integer current
    ) {
        Page page = new Page(current, 10);
        Page data = mpMusicService.page(page, null);
        return data;
    }




}
