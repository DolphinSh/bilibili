package com.charon.datasource.service.impl;

import com.charon.datasource.entity.Comment;
import com.charon.datasource.mapper.CommentMapper;
import com.charon.datasource.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> getAllComment() {
        return commentMapper.getAllComment();
    }

    @Override
    public List<Comment> getCommentByStatus(Integer status) {
        return commentMapper.getCommentByStatus(status);
    }

    @Override
    public boolean insetComment(Comment comment) {
        return false;
    }

    @Override
    public boolean updateStatusById(Comment comment) {
        Integer rows = commentMapper.updateStatusById(comment);

        if (rows == null)
            throw new NullPointerException("数据库更新操作异常,返回值不应为空");

        if (rows == 0)
            return false;

        return true;
    }

    @Override
    public Boolean deleteCommentById(Comment comment) {
        Integer id = comment.getId();

        if (id == null)
            throw new NullPointerException("欲删除数据的id不能为空");

        Integer rows = commentMapper.deleteCommentById(id);

        if (rows == null)
            throw new NullPointerException("数据库删除操作异常，返回值不应为空");

        if (rows == 0)
            return false;

        return true;
    }

}