package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.bean.MpMusicBean;
import com.example.demo.mapper.MpMusicMapper;
import com.example.demo.service.MpMusicService;
import org.springframework.stereotype.Service;

@Service
public class MpMusicServiceImpl extends ServiceImpl<MpMusicMapper, MpMusicBean> implements MpMusicService {
}
