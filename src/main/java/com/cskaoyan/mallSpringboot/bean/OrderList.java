package com.cskaoyan.mallSpringboot.bean;

import java.util.List;

public class OrderList {
    double actualPrice;
    int id;
    String orderSn;
    int orderStatusText;
    boolean isGroupin;
    List<OrderGood> goodList;
    OrderHandleOption handleOptions;

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public int getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(int orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public boolean isGroupin() {
        return isGroupin;
    }

    public void setGroupin(boolean groupin) {
        isGroupin = groupin;
    }

    public List<OrderGood> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<OrderGood> goodList) {
        this.goodList = goodList;
    }

    public OrderHandleOption getHandleOptions() {
        return handleOptions;
    }

    public void setHandleOptions(OrderHandleOption handleOptions) {
        this.handleOptions = handleOptions;
    }
}
