package com.cskaoyan.mallSpringboot.vo;

import java.util.List;

public class BaseResultVo<T> {
    private int total;
    private List<T> info;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getInfo() {
        return info;
    }

    public void setInfo(List<T> info) {
        this.info = info;
    }

}
