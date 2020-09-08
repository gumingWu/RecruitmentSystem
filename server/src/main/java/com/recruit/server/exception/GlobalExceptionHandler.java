package com.recruit.server.exception;

import com.recruit.server.util.ErrCode;
import com.recruit.server.util.JsonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecruitException.class)
    public JsonResponse handleRecruitException(RecruitException ex){
        return new JsonResponse(ex.getErrCode(),ex.getErrMessage());
    }
}
