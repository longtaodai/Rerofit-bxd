package com.dltao.bxd.app.api.response;

import java.util.List;

/**
 * Created by zhuoapp on 16/6/27.
 */
public class SimpleResult {
    private Integer result;
    private List<String> url;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }


    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }
}
