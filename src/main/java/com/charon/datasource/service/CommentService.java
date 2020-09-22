package com.charon.datasource.service;

import com.charon.datasource.entity.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {

    List<Comment> getAllComment();

    List<Comment> getCommentByStatus(Integer status);

    boolean insetComment(Comment comment);

    boolean updateStatusById(Comment comment);

    Boolean deleteCommentById(Comment comment);

}