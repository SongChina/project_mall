package com.cskaoyan.mallSpringboot.gss_vo;

public class StatisticsVo<T> {
    private int errno;
    private String errmsg;
    private StatisticsData<T> data;

    public StatisticsData getData() {
        return data;
    }

    public void setData(StatisticsData data) {
        this.data = data;
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
