package com.huashu.monitor.common;

/**
 * 返回给前端的状态码
 */
public enum ResponseCode {
    SUCCESS(0,"SUCCESS"), // 成功
    ERROR(1,"ERROR"), // 错误
    NEED_LOGIN(10,"NEED_LOGIN"), // 需要登录
    LACK_PERMISSION(11,"LACK_PERMISSION"), // 权限不足
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"); // 参数错误

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
