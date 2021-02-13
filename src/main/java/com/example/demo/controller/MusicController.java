package com.example.demo.controller;

import com.example.demo.mapper.MusicMapper;
import com.example.demo.model.MusicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
//@ResponseBody
@RestController // 是上面两个注解的合集
public class MusicController {

    @Autowired
    private MusicMapper musicMapper;

    @RequestMapping(path="/musics", method = {RequestMethod.GET})
    public List<MusicModel> getMusics() {
        List<MusicModel> musics = musicMapper.getMusics();
        System.out.println(musics);

        return musics;
    }
}
