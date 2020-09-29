package com.charon.datasource.entity;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JSONType(orders = {"code","msg","data"})
public class MsgData<T> {
    private Integer code;
    private String msg;
    private T data;
}


