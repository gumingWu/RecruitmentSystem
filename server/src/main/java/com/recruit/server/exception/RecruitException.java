package com.recruit.server.exception;

import com.recruit.server.util.ErrCode;

public class RecruitException extends RuntimeException{
    private String errCode;
    private String errMessage;

    public RecruitException(String errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public RecruitException(ErrCode errCode){
        this.errCode = errCode.getErrCode();
        this.errMessage = errCode.getErrMessage();
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
