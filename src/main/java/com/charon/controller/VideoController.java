package com.charon.controller;

import com.charon.datasource.entity.Video;
import com.charon.datasource.service.VideoService;
import com.charon.datasource.vo.MsgData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/video")
    public MsgData getVideoByStatus(@RequestParam(value = "status", defaultValue = "-1") Integer status) {
        List<Video> videoList = null;
        if (status.equals(-1)){
            videoList = videoService.getVideoList();
        }else {
            videoList = videoService.getVideoByStatus(status);
        }
        if (videoList == null){
            return MsgData.FAIL;
        }else {
            return MsgData.SUCCESS.data(videoList);
        }
    }

    @PutMapping("/video")
    public MsgData updateVideoType(@RequestParam("id") Integer id,
                                   @RequestParam("status") Integer status) {
        Video video = new Video(id, status);
        boolean success = videoService.updateVideo(video);
        return success ? MsgData.SUCCESS.data(null) : MsgData.FAIL.data(null);//不知道为什么不手动置null的话会自动将查询结果装配
    }

    @DeleteMapping("/video/{id}")
    public MsgData deleteVideoType(@PathVariable("id") Integer id) {
        boolean success = videoService.deleteVideoById(new Video(id));
        return success ? MsgData.SUCCESS.data(null) : MsgData.FAIL.data(null);
    }
}
