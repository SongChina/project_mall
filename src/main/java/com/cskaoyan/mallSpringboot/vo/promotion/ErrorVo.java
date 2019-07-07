package com.cskaoyan.mallSpringboot.vo.promotion;

public class ErrorVo {
    private int errno;
    private String errmsg;

    public ErrorVo() {
    }

    public ErrorVo(int errno, String errmsg) {
        this.errno = errno;
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
