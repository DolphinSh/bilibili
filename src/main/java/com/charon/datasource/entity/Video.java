package com.charon.datasource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data //Getter and Setter
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    private Integer id;
    private String name;
    private String url;
    private Integer uid;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private String type;

    public Video(Integer id) {
        this.id = id;
    }

    public Video(Integer id, Integer status) {
        this.id = id;
        this.status = status;
    }
}
