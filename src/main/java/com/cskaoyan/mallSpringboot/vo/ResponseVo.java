package com.cskaoyan.mallSpringboot.vo;

public class ResponseVo<T> {
    int errno;
    T  data;
    String errmas;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmas() {
        return errmas;
    }

    public void setErrmas(String errmas) {
        this.errmas = errmas;
    }

    public ResponseVo(int errno, T data, String errmas) {
        this.errno = errno;
        this.data = data;
        this.errmas = errmas;
    }

    public ResponseVo() {
    }
}
