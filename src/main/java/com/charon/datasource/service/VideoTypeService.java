package com.charon.datasource.service;

import com.charon.datasource.entity.VideoType;

import java.util.List;

public interface VideoTypeService {

    boolean insertVideoType(VideoType videoType);

    List<VideoType> getVideoTypeList();

    boolean updateVideoType(VideoType videoType);

    boolean deleteVideoType(VideoType videoType);
}
