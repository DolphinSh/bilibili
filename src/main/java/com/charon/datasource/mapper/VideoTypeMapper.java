package com.charon.datasource.mapper;

import com.charon.datasource.entity.VideoType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface VideoTypeMapper {

    @Select("select * from video_type")
    List<VideoType> getVideoType();

    @Update("update video_type set classify=#{classify},description=#{description} where id=#{id}")
    Integer updateVideoType(VideoType videoType);

    @Delete("delete from video_type where id=#{id}")
    Integer deleteVideoTypeById(Integer id);
}
