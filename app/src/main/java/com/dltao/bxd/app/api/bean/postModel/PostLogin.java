package com.dltao.bxd.app.api.bean.postModel;

/**
 * Created by ui on 2017/6/1.
 */
public class PostLogin {

    private String straccount;
    private String strPassword;
    private String strOpenid;
    private String strClientCode;

    public PostLogin(String straccount,String strPassword,String strOpenid,String strClientCode){
        this.straccount=straccount;
        this.strPassword=strPassword;
        this.strOpenid=strOpenid;
        this.strClientCode=strClientCode;
    }

    public String getStraccount() {
        return straccount;
    }

    public void setStraccount(String straccount) {
        this.straccount = straccount;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public String getStrOpenid() {
        return strOpenid;
    }

    public void setStrOpenid(String strOpenid) {
        this.strOpenid = strOpenid;
    }

    public String getStrClientCode() {
        return strClientCode;
    }

    public void setStrClientCode(String strClientCode) {
        this.strClientCode = strClientCode;
    }
}
