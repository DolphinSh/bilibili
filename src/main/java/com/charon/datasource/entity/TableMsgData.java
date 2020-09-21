package com.charon.datasource.entity;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JSONType(orders = {"code","msg","count","data"})
public class TableMsgData<T> {
    private Integer code;
    private String msg;
    private Integer count;
    private T data;
}
