package com.bill.xiaogu.exception;

import com.bill.xiaogu.dto.WrapMapper;
import com.bill.xiaogu.dto.Wrapper;
import com.bill.xiaogu.emums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler{


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper bindException(IllegalArgumentException e) {
        log.error(e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GLOBAL_ILLEGAL_REQUEST.code(), ErrorCodeEnum.GLOBAL_ILLEGAL_REQUEST.message());
    }


    @ExceptionHandler(ErrorParamException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Wrapper bindException(ErrorParamException e) {
        log.error(e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GLOBAL_ERROR_PARAM_REQUEST.code(), ErrorCodeEnum.GLOBAL_ERROR_PARAM_REQUEST.message());
    }

}
