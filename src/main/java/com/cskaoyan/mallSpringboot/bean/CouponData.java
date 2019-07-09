package com.cskaoyan.mallSpringboot.bean;

import java.util.List;

public class CouponData {
    int count;
    List<Coupon> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Coupon> getData() {
        return data;
    }

    public void setData(List<Coupon> data) {
        this.data = data;
    }
}
