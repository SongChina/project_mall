package com.cskaoyan.mallSpringboot.renguopingVO;

import java.util.List;

public class WxResultVo<T> {
    int count;
    List<T> data;
    int totalPages;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPage) {
        this.totalPages = totalPage;
    }
}
