package com.cskaoyan.mallSpringboot.renguopingVO;

public class ResponseVo {
    int errno;
    Object data;
    String errmsg;

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

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmas) {
        this.errmsg = errmas;
    }

}
