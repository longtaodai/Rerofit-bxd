package com.dltao.bxd.app.api.response;

/**
 * Created by leason on 2016/5/15.
 */
public class HttpResponse<T> {

    private int Count;
    private boolean IsSuccess;
    private String Message;
    private T Data;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public boolean isSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        IsSuccess = isSuccess;
    }

    public T getData() {
        return Data;
    }

    public void setData(T Data) {
        this.Data = Data;
    }
}
