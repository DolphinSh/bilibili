package com.charon.controller;

import com.charon.datasource.entity.VideoType;
import com.charon.datasource.service.VideoService;
import com.charon.datasource.vo.MsgData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/video/type")
    @ResponseBody
    public MsgData getVideoTypeList() {
        List<VideoType> videoTypeList = videoService.getVideoTypeList();
        if (videoTypeList == null) {
            return MsgData.ERROR;
        } else {
            return MsgData.SUCCESS.data(videoTypeList);
        }
    }
}
