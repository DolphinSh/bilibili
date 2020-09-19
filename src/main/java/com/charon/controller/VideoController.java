package com.charon.controller;

import com.charon.datasource.entity.VideoType;
import com.charon.datasource.service.VideoService;
import com.charon.datasource.vo.MsgData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

    @PutMapping("/video/type")
    @ResponseBody
    public MsgData updateVideoType(@RequestParam("id") Integer id,
                                   @RequestParam("classify") String classify,
                                   @RequestParam("description") String description) {
        VideoType videoType = new VideoType(id, classify, description);
        boolean success = videoService.updateVideoType(videoType);
        return success ? MsgData.SUCCESS.data(null) : MsgData.FAIL.data(null);//不知道为什么不手动置null的话会自动将查询结果装配
    }

    @DeleteMapping("/video/type/{id}")
    @ResponseBody
    public MsgData deleteVideoType(@PathVariable("id") Integer id) {
        boolean success = videoService.deleteVideoType(new VideoType(id));
        return success ? MsgData.SUCCESS.data(null) : MsgData.FAIL.data(null);
    }
}
