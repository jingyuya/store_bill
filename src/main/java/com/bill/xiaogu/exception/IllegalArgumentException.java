package com.bill.xiaogu.exception;

public class IllegalArgumentException extends RuntimeException{

    public IllegalArgumentException() {
    }

    public IllegalArgumentException(String message) {
        super(message);
    }

    public IllegalArgumentException(Throwable cause) {
        super(cause);
    }

    public IllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

}
