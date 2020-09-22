package com.charon.controller;

import com.charon.datasource.entity.Comment;
import com.charon.datasource.entity.VideoType;
import com.charon.datasource.service.CommentService;
import com.charon.datasource.vo.MsgData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comment/manage")
    @ResponseBody
    public MsgData getCommentByStatus(@RequestParam(value = "status", defaultValue = "-1") Integer status) {
        List<Comment> commentList = null;
        if (status.equals(-1)){
            commentList = commentService.getAllComment();
            System.out.println("s"+status);
        }else {
            commentList = commentService.getCommentByStatus(status);
            System.out.println(status);
        }
        if (commentList == null){
            return MsgData.FAIL;
        }else {
            return MsgData.SUCCESS.data(commentList);
        }
    }


    @PutMapping("/comment/manage")
    @ResponseBody
    public MsgData updateVideoType(@RequestParam("id") Integer id,
                                   @RequestParam("status") Integer status) {
        Comment comment = new Comment(id, status);
        boolean success = commentService.updateStatusById(comment);
        return success ? MsgData.SUCCESS.data(null) : MsgData.FAIL.data(null);//不知道为什么不手动置null的话会自动将查询结果装配
    }


    @DeleteMapping("/comment/manage/{id}")
    @ResponseBody
    public MsgData deleteVideoType(@PathVariable("id") Integer id) {
        boolean success = commentService.deleteCommentById(new Comment(id));
        return success ? MsgData.SUCCESS.data(null) : MsgData.FAIL.data(null);
    }

}
