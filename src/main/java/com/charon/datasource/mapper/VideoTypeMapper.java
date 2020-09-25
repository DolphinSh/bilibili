package com.charon.datasource.mapper;

import com.charon.datasource.entity.VideoType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VideoTypeMapper {

    @Insert("insert into video_type(classify,description) values(#{classify},#{description})")
    Integer insertVideoType(VideoType videoType);

    @Delete("delete from video_type where id=#{id}")
    Integer deleteVideoTypeById(Integer id);

    @Update("update video_type set classify=#{classify},description=#{description} where id=#{id}")
    Integer updateVideoType(VideoType videoType);

    @Select("select * from video_type")
    List<VideoType> getVideoType();
}
