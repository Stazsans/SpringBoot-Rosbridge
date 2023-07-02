package com.ros.result;

public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS(200),

    /**
     * 失败
     */
    FAIL(400),

    /**
     * 账户不存在
     */
    AccountNotExistence(401),

    /**
     * 密码错误
     */
    IncorrectPassword(402),

    /**
     * 未登录
     */
    NotLogin(403),

    /**
     * 接口不存在
     */
    NOT_FOUND(404),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500);
    public final int code;

    ResultEnum(int code) {
        this.code = code;
    }
}
