package com.dltao.bxd.app.api.response;

import java.util.List;

/**
 * Created by leason on 2016/6/2.
 */
public class HttpResponseListData<T> {

    private List<T> Data;

    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> Data) {
        this.Data = Data;
    }
}
