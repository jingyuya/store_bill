package com.bill.xiaogu.emums;

public enum ErrorCodeEnum {

    GLOBAL_ILLEGAL_REQUEST(10001,"非法请求"),
    GLOBAL_ERROR_PARAM_REQUEST(10002,"参数错误"),


    SERVER_INTERNAL_ERROR(50001,"服务器内部错误");

    private int code;

    private String message;


    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * Msg string.
     *
     * @return the string
     */
    public String message() {
        return message;
    }

    /**
     * Code int.
     *
     * @return the int
     */
    public int code() {
        return code;
    }

    /**
     * Gets enum.
     *
     * @param code the code
     * @return the enum
     */
    public static ErrorCodeEnum getEnum(int code) {
        for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        return null;
    }
}
