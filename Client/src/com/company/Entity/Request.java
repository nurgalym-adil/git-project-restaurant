package com.company.Entity;

import java.io.Serializable;

public class Request implements Serializable {
    private String str1;
    private String str2;
    private String str3;
    private Object object1;
    private Object object2;

    public Request(String str1, String str2, String str3, Object object1, Object object2) {
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
        this.object1 = object1;
        this.object2 = object2;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3;
    }

    public Object getObject1() {
        return object1;
    }

    public void setObject1(Object object1) {
        this.object1 = object1;
    }

    public Object getObject2() {
        return object2;
    }

    public void setObject2(Object object2) {
        this.object2 = object2;
    }
}
