package com.charon.datasource.service;

import com.charon.datasource.entity.VideoType;

import java.util.List;

public interface VideoService {

    List<VideoType> getVideoTypeList();

    boolean updateVideoType(VideoType videoType);

    boolean deleteVideoType(VideoType videoType);
}
