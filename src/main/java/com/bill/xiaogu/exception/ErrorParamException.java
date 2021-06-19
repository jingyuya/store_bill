package com.bill.xiaogu.exception;

public class ErrorParamException extends RuntimeException{

    public ErrorParamException() {
    }

    public ErrorParamException(String message) {
        super(message);
    }

    public ErrorParamException(Throwable cause) {
        super(cause);
    }

    public ErrorParamException(String message, Throwable cause) {
        super(message, cause);
    }

}
