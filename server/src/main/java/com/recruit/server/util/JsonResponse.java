package com.recruit.server.util;

public class JsonResponse<T> {
    private String errCode;
    private String errMessage;
    private T data;

    public JsonResponse() {
    }

    public JsonResponse(String errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public JsonResponse(String errCode, String errMessage, T data) {
        this.errCode = errCode;
        this.errMessage = errMessage;
        this.data = data;
    }

    public JsonResponse(ErrCode errcode){
        this.errCode = errcode.getErrCode();
        this.errMessage = errcode.getErrMessage();
    }

    public JsonResponse(ErrCode errcode, T data){
        this.errCode = errcode.getErrCode();
        this.errMessage = errcode.getErrMessage();
        this.data = data;
    }

    public static JsonResponse success(){
        return new JsonResponse(ErrCode.SUCCESS);
    }

    public static <T> JsonResponse<T> success(T data){
        return new JsonResponse<>(ErrCode.SUCCESS, data);
    }

    public static JsonResponse error(){
        return new JsonResponse(ErrCode.ERROR);
    }

    public static <T> JsonResponse<T> error(T data){
        return new JsonResponse(ErrCode.ERROR, data);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
