package com.dltao.bxd.app.api.bean;

import java.io.Serializable;

/**
 * Created by ui on 2016/4/12.
 */
public class User implements Serializable{
    private String userType;
    private String strAreaCode;
    private String strPhone;
    private String  Token;
    private String strName;
    private String strShopName;
    private String strAddress;
    private String strPayPwd;
    private Boolean bIsGoldUser;
    private Integer payWay;
    private String password;
    private String machineCode;
    private Boolean bIsPromotion;
    private Boolean IsNumberPwd;
    private Boolean bUrlOveride;
    private String  h5Url;
    private String strIsPromotionType;
    private String strAccount;
    private Boolean IsNewUser;


    public Boolean getIsNewUser() {
        return IsNewUser;
    }

    public void setIsNewUser(Boolean isNewUser) {
        IsNewUser = isNewUser;
    }

    public String getStrAccount() {
        return strAccount;
    }

    public void setStrAccount(String strAccount) {
        this.strAccount = strAccount;
    }

    public String getStrIsPromotionType() {
        return strIsPromotionType;
    }

    public void setStrIsPromotionType(String strIsPromotionType) {
        this.strIsPromotionType = strIsPromotionType;
    }

    public Boolean getIsNumberPwd() {
        return IsNumberPwd;
    }

    public void setIsNumberPwd(Boolean isNumberPwd) {
        IsNumberPwd = isNumberPwd;
    }

    public Boolean getbUrlOveride() {
        return bUrlOveride;
    }

    public void setbUrlOveride(Boolean bUrlOveride) {
        this.bUrlOveride = bUrlOveride;
    }

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getStrShopName() {
        return strShopName;
    }

    public void setStrShopName(String strShopName) {
        this.strShopName = strShopName;
    }

    public Boolean getbIsPromotion() {
        return bIsPromotion;
    }

    public void setbIsPromotion(Boolean bIsPromotion) {
        this.bIsPromotion = bIsPromotion;
    }

    public String getStrPhone() {
        return strPhone;
    }

    public void setStrPhone(String strPhone) {
        this.strPhone = strPhone;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public String getStrAddress() {
        return strAddress;
    }

    public void setStrAddress(String strAddress) {
        this.strAddress = strAddress;
    }

    public String getStrPayPwd() {
        return strPayPwd;
    }

    public void setStrPayPwd(String strPayPwd) {
        this.strPayPwd = strPayPwd;
    }

    public Boolean getbIsGoldUser() {
        return bIsGoldUser;
    }

    public void setbIsGoldUser(Boolean bIsGoldUser) {
        this.bIsGoldUser = bIsGoldUser;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getStrAreaCode() {
        return strAreaCode;
    }

    public void setStrAreaCode(String strAreaCode) {
        this.strAreaCode = strAreaCode;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }
}
