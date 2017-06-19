package com.dltao.bxd.app.bean;

import java.io.Serializable;

/**
 * Created by ui on 2017/6/13
 *
 * 用户登陆实体
 * .
 */
public class LoginModel implements Serializable{

    private int length;
    private String sn;
    private String flag;
    private Integer type;
    private int param_len;
    private Integer name_length;
    private String name;
    private Integer pass_length;
    private String pass;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public int getParam_len() {
        return param_len;
    }

    public void setParam_len(int param_len) {
        this.param_len = param_len;
    }

    public Integer getName_length() {
        return name_length;
    }

    public void setName_length(Integer name_length) {
        this.name_length = name_length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPass_length() {
        return pass_length;
    }

    public void setPass_length(Integer pass_length) {
        this.pass_length = pass_length;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
