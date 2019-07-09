package com.cskaoyan.mallSpringboot.renguopingVO;

import java.util.List;

public class WxResultVo {
    int count;
    List[] data;
    int totalPage;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List[] getData() {
        return data;
    }

    public void setData(List[] data) {
        this.data = data;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
