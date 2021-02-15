package com.example.demo.controller;

import com.example.demo.dto.PaginationDTO;
import com.example.demo.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@Controller
//@ResponseBody
@RestController // 是上面两个注解的合集
public class MusicController {

    @Autowired
    MusicService musicService;

    @Value("${TX_YUN_IP}")
    private String tx_yun_ip;

    // 列表
    // @RequestMapping(value="/musics", method = {RequestMethod.GET})
    @GetMapping("/musics")
    public PaginationDTO getMusics(
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "current", defaultValue = "1") Integer current,
            @RequestParam(name = "searchKey", required = false) String searchKey
    ) {
        System.out.println(tx_yun_ip);
        PaginationDTO musics = musicService.list(pageSize, current, searchKey);
        return musics;
    }

    // 新增
    @PostMapping("/musics/add")
    public Map<String, Object> addMusics(
            @RequestBody Map<String, Object> body
    ) {
        String name = (String) body.get("name");
        String album = (String) body.get("album");
        String singer = (String) body.get("singer");
        Boolean isSuccess = musicService.add(name, album, singer);
        body.put("isSuccess", isSuccess); // 是否成功
        return body;
    }

    // 修改
    @PostMapping("/musics/edit")
    public Map<String, Object> editMusics(
            @RequestBody Map<String, Object> body
    ) {
        Boolean isSuccess = musicService.edit(body);
        body.put("isSuccess", isSuccess); // 是否成功
        return body;
    }

    // 删除
    @PostMapping("/musics/delete")
    public Map<String, Object> deleteMusics(
            @RequestBody Map<String, Object> body
    ) {
        int id = (int) body.get("id");
        Boolean isSuccess = musicService.delete(id);
        body.put("isSuccess", isSuccess); // 是否成功
        return body;
    }
}
