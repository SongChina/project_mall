package com.cskaoyan.mallSpringboot.vo;

public class ResponseVo {
    int errno;
    Object data;
    String errmas;

    public ResponseVo() {
    }

    public ResponseVo(int errno, Object data, String errmas) {
        this.errno = errno;
        this.data = data;
        this.errmas = errmas;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrmas() {
        return errmas;
    }

    public void setErrmas(String errmas) {
        this.errmas = errmas;
    }
}
