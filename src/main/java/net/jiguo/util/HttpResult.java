package net.jiguo.util;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/9/28.
 */

public class HttpResult implements Serializable {

    private Integer status;
    private String msg;
    private Object data;

    public HttpResult() {
    }

    public HttpResult(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public HttpResult(Integer status, Object data) {
        this.status = status;
        this.data = data;
    }

    public HttpResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
