package com.cskaoyan.mallSpringboot.renguopingVO;

import java.util.Date;
import java.util.List;

public class OrderInfo {
    int id;
    String oderSn;
    String orderStatusText;
    String consignee;
    String mobile;
    String address;
    Date addTime;
    Double goodsPrice;
    Double freightPrice;
    Double couponPrice;
    Double actualPrice;
    List handleOption;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOderSn() {
        return oderSn;
    }

    public void setOderSn(String oderSn) {
        this.oderSn = oderSn;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(Double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public Double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(Double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public List getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(List handleOption) {
        this.handleOption = handleOption;
    }
}
