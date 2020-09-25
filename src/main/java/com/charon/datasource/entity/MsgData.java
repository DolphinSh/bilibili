package com.charon.datasource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgData<T> {
    private Integer code;
    private String msg;
    private T data;
}
