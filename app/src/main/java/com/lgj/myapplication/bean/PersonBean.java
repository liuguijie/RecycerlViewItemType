package com.lgj.myapplication.bean;


import java.security.PrivateKey;
import java.util.List;

/**
 * @author 刘桂杰
 * @date 2020/8/18 13:42
 * @description $
 */
public class PersonBean {
    public static final int itemTypeDate = 0;
    public static final int itemTypeImage = 1;
    private String data;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int type;

    public PersonBean(String data, int type) {
        this.data = data;
        this.type = type;
    }

    public String getDate() {
        return data;
    }

    public void setDate(String data) {
        this.data = data;
    }
}
