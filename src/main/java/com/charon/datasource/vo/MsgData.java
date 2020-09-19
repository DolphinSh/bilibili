package com.charon.datasource.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MsgData<T> {
    private Integer code;
    @JsonProperty("msg")
    private String message;
    private T data;

    public static MsgData SUCCESS = new MsgData(0, "success");
    public static MsgData FAIL = new MsgData(1, "fail");
    public static MsgData ERROR = new MsgData(-1, "error");

    public MsgData() {

    }

    public MsgData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public MsgData data(T data) {
        this.data = data;
        return this;
    }
}
