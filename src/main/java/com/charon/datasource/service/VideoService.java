package com.charon.datasource.service;

import com.charon.datasource.entity.Video;

import java.util.List;

public interface VideoService {

    List<Video> getVideoList();

    List<Video> getVideoByStatus(Integer status);

    boolean updateVideo(Video video);

    boolean deleteVideoById(Video video);
}
