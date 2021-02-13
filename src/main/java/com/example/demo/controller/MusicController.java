package com.example.demo.controller;

import com.example.demo.dto.PaginationDTO;
import com.example.demo.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController // 是上面两个注解的合集
public class MusicController {

    @Autowired
    MusicService musicService;

    // @GetMapping("/musics")
    @RequestMapping(value="/musics", method = {RequestMethod.GET})
    public PaginationDTO getMusics(
            @RequestParam(name="pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(name="current", defaultValue = "1") Integer current
    ) {
        PaginationDTO musics = musicService.list(pageSize, current);
        System.out.println(musics);
        return musics;
    }
}
