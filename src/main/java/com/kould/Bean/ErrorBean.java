package com.kould.Bean;

public class ErrorBean {
    private String url ;
    private String msg ;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ErrorBean(String url, String msg) {
        this.url = url ;
        this.msg = msg ;
    }

}
