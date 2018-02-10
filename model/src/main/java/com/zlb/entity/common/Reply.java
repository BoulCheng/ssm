package com.zlb.entity.common;


import java.io.Serializable;

public class Reply implements Serializable {
    private static final long serialVersionUID = 6543751866024162628L;
    private static final int RES_SUCCESS = 0;

    private int res;
    private String msg;
    private Object data;
    private String time;

    public Reply(){
        this.res = RES_SUCCESS;
    }

    public Reply(int res, String msg) {
        this.res = res;
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public Reply(Object data, int res, String msg) {
        this.data = data;
        this.res = res;
        this.msg = msg;
    }

}
