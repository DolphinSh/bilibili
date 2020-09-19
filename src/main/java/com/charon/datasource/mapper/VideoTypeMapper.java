package com.charon.datasource.mapper;

import com.charon.datasource.entity.VideoType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VideoTypeMapper {

    @Select("select * from video_type")
    List<VideoType> getVideoType();
}
