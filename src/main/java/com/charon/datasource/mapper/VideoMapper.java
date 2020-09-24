package com.charon.datasource.mapper;

import com.charon.datasource.entity.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VideoMapper {

    @Select("select a.id,a.name,a.url,a.uid,a.createTime,a.updateTime,a.status,b.classify as type from video a,video_type b where a.type=b.id")
    List<Video> getVideoList();

    @Select("select a.id,a.name,a.url,a.uid,a.createTime,a.updateTime,a.status,b.classify as type from video a,video_type b where a.type=b.id and status = #{status}")
    List<Video> getVideoByStatus(Integer status);

    @Update("update video set status=#{status} where id=#{id}")
    Integer updateVideo(Video video);

    @Delete("delete from video where id=#{id}")
    Integer deleteVideoById(Integer id);

}
