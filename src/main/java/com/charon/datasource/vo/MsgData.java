package com.charon.datasource.vo;

<<<<<<< HEAD
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

    public MsgData data(T data) {
        this.data = data;
        return this;
    }
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MsgData {
    private Integer code;
    private String msg;
>>>>>>> 3ed750d... 新增：登录拦截器
}
