package com.cskaoyan.mallSpringboot.bean;

import java.util.Date;

public class GrouponCreate {
    private String discount;
    private String discountMember;
    private Date expireTime;
    private String goodsId;

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountMember() {
        return discountMember;
    }

    public void setDiscountMember(String discountMember) {
        this.discountMember = discountMember;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
