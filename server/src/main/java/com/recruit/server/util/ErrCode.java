package com.recruit.server.util;

public enum ErrCode {
    SUCCESS("SUC00", "操作成功"),
    ERROR("ERR01", "操作失败");
    private String errCode;
    private String errMessage;

    ErrCode(String errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }
}
