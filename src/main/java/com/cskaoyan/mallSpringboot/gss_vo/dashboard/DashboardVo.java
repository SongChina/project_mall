package com.cskaoyan.mallSpringboot.gss_vo.dashboard;

public class DashboardVo {
    private DashboardData data;
    private String errmsg;
    private int errno;

    public DashboardData getData() {
        return data;
    }

    public void setData(DashboardData data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }
}
