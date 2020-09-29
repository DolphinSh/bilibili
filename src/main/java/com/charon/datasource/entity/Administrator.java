package com.charon.datasource.entity;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JSONType(orders = {"id","username","password","nickname","head_img_url","mobile","gender","enabled","permission"
        ,"createTime","updateTime","is_del"})
public class Administrator {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String head_img_url;
    private String mobile;
    private Integer gender;
    private Integer enabled;
    private Integer permission;
    private Date createTime;
    private Date updateTime;
    private Integer is_del;
}
