package com.charon.datasource.mapper;

import com.charon.datasource.entity.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VideoMapper {

    @Select("select * from video")
    List<Video> getVideoList();

    @Update("update video set status=#{status} where id=#{id}")
    Integer updateVideo(Video video);

    @Delete("delete from video where id=#{id}")
    Integer deleteVideoById(Integer id);

}
