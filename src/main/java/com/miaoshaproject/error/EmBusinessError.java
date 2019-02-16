package com.miaoshaproject.error;

public enum EmBusinessError implements CommonError {
    PARAMETER_VALIDATION_ERROR(10001, "Invalid Input Value"),
    UNKNOWN_ERROR(10002, "Unknown Error"),
    USER_NOT_EXIST(20001,"User Not Exists"),
    USER_LOGIN_FAIL(20002,"Wrong phone number or password"),
    ;

    private int errCode;
    private String errMsg;

    private EmBusinessError(int errCode, String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
