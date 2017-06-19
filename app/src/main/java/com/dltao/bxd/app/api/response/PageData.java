package com.dltao.bxd.app.api.response;

/**
 * Created by leason on 2016/6/2.
 */
public class PageData {
    private Integer totalPage;      //总页数
    private Integer pageIndex;      //当前页码
    private Integer totalRec;       //总记录数
    private Integer pageSize;       //每页记录数

    public PageData(){

    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalRec() {
        return totalRec;
    }

    public void setTotalRec(Integer totalRec) {
        this.totalRec = totalRec;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
