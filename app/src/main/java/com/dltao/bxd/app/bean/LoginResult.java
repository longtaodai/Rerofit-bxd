package com.dltao.bxd.app.bean;

import java.io.Serializable;

/**
 * Created by ui on 2017/6/13.
 */
public class LoginResult implements Serializable {

    private Integer tag;
    private Integer length;
    private String result;
    private Integer IP_len;
    private String IP;
    private Integer Port_len;
    private Integer Port;

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getIP_len() {
        return IP_len;
    }

    public void setIP_len(Integer IP_len) {
        this.IP_len = IP_len;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Integer getPort_len() {
        return Port_len;
    }

    public void setPort_len(Integer port_len) {
        Port_len = port_len;
    }

    public Integer getPort() {
        return Port;
    }

    public void setPort(Integer port) {
        Port = port;
    }
}
