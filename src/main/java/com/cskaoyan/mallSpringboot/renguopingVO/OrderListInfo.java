package com.cskaoyan.mallSpringboot.renguopingVO;

import java.util.List;

public class OrderListInfo {
    int id;//订单id
    String orderSn;
    String orderStatusText;
    Boolean isGroup;
    List[] goodsList;
    List handleOption;
    Double actualPrice;

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

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public Boolean getGroup() {
        return isGroup;
    }

    public void setGroup(Boolean group) {
        isGroup = group;
    }

    public List[] getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List[] goodsList) {
        this.goodsList = goodsList;
    }

    public List getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(List handleOption) {
        this.handleOption = handleOption;
    }

    public Double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }
}
