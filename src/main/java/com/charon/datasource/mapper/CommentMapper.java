package com.charon.datasource.mapper;

import com.charon.datasource.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    //    查询所有评论
    @Select("select * from comment")
    List<Comment> getAllComment();

    //    根据评审状态查询
    @Select("select * from comment where status = #{status}")
    List<Comment> getCommentByStatus(Integer status);

    //    增加评论内容
    @Insert("insert into comment (aimId,type,content,uid) values (#{aimId},#{type},#{content},#{uid})")
    Integer insetComment(Comment comment);

    //    修改审核状态
    @Update("update comment set status=#{status} where id=#{id}")
    Integer updateStatusById(Comment comment);

    //    删除评论
    @Delete("delete from comment where id=#{id}")
    Integer deleteCommentById(Integer id);

}
