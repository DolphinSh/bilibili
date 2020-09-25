package com.charon.datasource.entity;

import lombok.*;

import java.util.Date;

//@Getter
//@Setter
@Data //Getter and  Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class Comment {
    private Integer id;
    private Integer video;
    private Integer commentId;
    private Integer aimId;
    private String content;
    private Integer uid;
    private Integer status;
    private Date createTime;

    public Comment(Integer id) {
        this.id = id;
    }

    public Comment(Integer id,Integer status){
        this.id = id;
        this.status = status;
    }
}
