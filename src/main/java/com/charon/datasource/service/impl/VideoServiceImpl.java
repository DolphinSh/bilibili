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
            throw new NullPointerException("数据库更新操作异常,返回值不为空");

        if (rows == 0)
            return false;

        return true;
    }

    @Override
    public boolean deleteVideoType(VideoType videoType) {
        Integer id = videoType.getId();

        if (id == null)
            throw new NullPointerException("欲删除数据的id不能为空");

        Integer rows = videoTypeMapper.deleteVideoTypeById(id);

        if (rows == null)
            throw new NullPointerException("数据库删除操作异常，返回值不为空");

        if (rows == 0)
            return false;

        return true;
    }
}
