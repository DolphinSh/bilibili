package com.charon.datasource.entity;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JSONType(orders = {"roleId","roleName","roleCode","comments","createTime","updateTime"})
public class Permission {
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private String comments;
    private Date createTime;
    private Date updateTime;
}
