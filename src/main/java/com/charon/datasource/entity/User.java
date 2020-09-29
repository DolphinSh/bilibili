package com.charon.datasource.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JSONType(orders = {"id","uid","nickname","password","head_img_url","level","gender","age","enable","createTime",
        "updateTime","is_del"})
public class User {
    private Integer id;
    private Integer uid;
    private String nickname;
    private String password;
    private String head_img_url;
    private Integer level;
    private Integer gender;
    private Integer age;
    private Integer enable;
    private Date createTime;
    private Date updateTime;
    private Integer is_del;
}
