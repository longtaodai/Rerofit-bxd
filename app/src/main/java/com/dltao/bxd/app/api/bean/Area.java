package com.dltao.bxd.app.api.bean;

import java.io.Serializable;

/**
 * Created by ui on 2016/4/25.
 */
public class Area implements Serializable{

    public String strGuid;
    public String  strTypeCode;
    public String strTypeName;


    public Area(String strGuid, String strTypeCode, String strTypeName){
        this.strGuid=strGuid;
        this.strTypeCode=strTypeCode;
        this.strTypeName=strTypeName;
    }

    public String getStrGuid() {
        return strGuid;
    }

    public void setStrGuid(String strGuid) {
        this.strGuid = strGuid;
    }

    public String getStrTypeCode() {
        return strTypeCode;
    }

    public void setStrTypeCode(String strTypeCode) {
        this.strTypeCode = strTypeCode;
    }

    public String getStrTypeName() {
        return strTypeName;
    }

    public void setStrTypeName(String strTypeName) {
        this.strTypeName = strTypeName;
    }
}
