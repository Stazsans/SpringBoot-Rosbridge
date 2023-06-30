package com.ros.result;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result() {
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
    public Result<T> setCode(ResultEnum resultEnum) {
        this.code = resultEnum.code;
        return this;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

}
