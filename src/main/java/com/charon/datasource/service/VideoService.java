package com.charon.datasource.service;

import com.charon.datasource.entity.Video;

import java.util.List;

public interface VideoService {

    List<Video> getVideoList();

    boolean updateVideo(Video video);

    boolean deleteVideoById(Video video);
}
