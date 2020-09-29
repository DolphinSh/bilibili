package com.charon.datasource.entity;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JSONType(orders = {"id","parentId","name","url","path","css","list"})
public class Menu {
    private Integer id;
    private Integer parentId;
    private String name;
    private String url;
    private String path;
    private String css;
    private List<Menu> list;
}
