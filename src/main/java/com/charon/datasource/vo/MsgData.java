package com.charon.datasource.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MsgData<T> {
    private Integer code;
    @JsonProperty("msg")
    private String message;
    private T data;

    public final static MsgData SUCCESS = new MsgData(0, "success", null);
    public final static MsgData FAIL = new MsgData(1, "fail", null);
    public final static MsgData ERROR = new MsgData(-1, "error", null);

    public MsgData() {

    }

    public MsgData(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
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
