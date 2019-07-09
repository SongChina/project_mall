package com.cskaoyan.mallSpringboot.renguopingVO;

import java.util.List;

public class ResultVo<T> {
    private int total;
    private List<T> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> info) {
        this.items = info;
    }

}
