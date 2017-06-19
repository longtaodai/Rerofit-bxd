package com.dltao.bxd.app.api.response;

/**
 * Created by leason on 2016/6/2.
 */
public class HttpResponseHeader {

    private int errCode;
    private String errMsg;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
