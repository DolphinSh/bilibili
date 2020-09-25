package com.charon.datasource.service.impl;

import com.charon.datasource.entity.Video;
import com.charon.datasource.mapper.VideoMapper;
import com.charon.datasource.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper videoMapper;

    @Override
    public List<Video> getVideoList() {
        return videoMapper.getVideoList();
    }

    @Override
    public List<Video> getVideoByStatus(Integer status) {
        return videoMapper.getVideoByStatus(status);
    }

    @Override
    public boolean updateVideo(Video video) {
        Integer rows = videoMapper.updateVideo(video);

        if (rows==null)
            throw new NullPointerException("数据库更新操作异常,返回值不应为空");

        if (rows == 0)
            return false;

        return true;
    }

    @Override
    public boolean deleteVideoById(Video video) {
        Integer id = video.getId();

        if(id==null)
            throw new NullPointerException("欲删除数据的id不能为空");

        Integer rows = videoMapper.deleteVideoById(id);

        if (rows == null)
            throw new NullPointerException("数据库删除操作异常，返回值不应为空");

        if (rows == 0)
            return false;

        return true;
    }
}
