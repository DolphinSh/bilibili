package com.charon.datasource.service.impl;

import com.charon.datasource.entity.VideoType;
import com.charon.datasource.mapper.VideoTypeMapper;
import com.charon.datasource.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoTypeMapper videoTypeMapper;

    @Override
    public List<VideoType> getVideoTypeList() {
        return videoTypeMapper.getVideoType();
    }

    @Override
    public boolean updateVideoType(VideoType videoType) {
        Integer rows = videoTypeMapper.updateVideoType(videoType);
        if (rows == null)
            throw new NullPointerException("更新数据库异常");

        if (rows == 0)
            return false;

        return true;
    }
}
