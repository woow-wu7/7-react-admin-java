package com.example.demo.controller;

import com.example.demo.dto.PaginationDTO;
import com.example.demo.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@Controller
//@ResponseBody
@RestController // 是上面两个注解的合集
public class MusicController {

    @Autowired
    MusicService musicService;

    // 列表
    // @RequestMapping(value="/musics", method = {RequestMethod.GET})
    @GetMapping("/musics")
    public PaginationDTO getMusics(
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "current", defaultValue = "1") Integer current
    ) {
        PaginationDTO musics = musicService.list(pageSize, current);
        System.out.println(musics);
        return musics;
    }

    // 新增
    @PostMapping("/musics")
    public Map<String, Object> addMusics(
            @RequestBody Map<String, Object> body
    ) {
        System.out.println(body);
        String name = (String) body.get("name");
        String album = (String) body.get("album");
        String singer = (String) body.get("singer");
        Boolean isSuccess = musicService.add(name, album, singer);
        body.put("isSuccess", isSuccess); // 是否插入成功
        return body;
    }

    // 删除
}
