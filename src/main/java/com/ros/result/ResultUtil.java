package com.ros.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ros.VO.PageInfo;

import java.util.List;

public class ResultUtil {

    public static <T> Result<T> defineSuccess(Integer code, T data) {
        Result<T> result = new Result<>();
        return result.setCode(code).setData(data);
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS).setData(data);
        return result;
    }

    public static <T> Result<T> success(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS).setMsg(msg);
        return result;
    }

    public static <P> Result<PageInfo<P>> pageSuccess(IPage<P> page) {
        PageInfo<P> pageInfo = new PageInfo<P>().setList(page.getRecords()).setTotal(page.getTotal());
        return success(pageInfo);
    }

    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.FAIL).setMsg(msg);
        return result;
    }

    public static <T> Result<T> defineFail(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code).setMsg(msg);
        return result;
    }

    public static <T> Result<T> define(int code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code).setMsg(msg).setData(data);
        return result;
    }
}