package com.charon.datasource.entity;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JSONType(orders = {"authorityId","authorityName","menuUrl","menuPath","parentId","isMenu","menuIcon","createTime","updateTime"})
public class TableMenu {
    private Integer authorityId;
    private String authorityName;
    private String menuUrl;
    private String menuPath;
    private Integer parentId;
    private Integer isMenu;
    private String menuIcon;
    private Date createTime;
    private Date updateTime;
}
