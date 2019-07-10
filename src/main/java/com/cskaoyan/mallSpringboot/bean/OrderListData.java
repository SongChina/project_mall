package com.cskaoyan.mallSpringboot.bean;

import java.util.List;

public class OrderListData {
    int count;
    int totalPages;
    List<OrderList> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<OrderList> getData() {
        return data;
    }

    public void setData(List<OrderList> data) {
        this.data = data;
    }

    public OrderListData() {
    }

    public OrderListData(int count, int totalPages, List<OrderList> data) {
        this.count = count;
        this.totalPages = totalPages;
        this.data = data;
    }
}
