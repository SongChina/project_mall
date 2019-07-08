package com.cskaoyan.mallSpringboot.bean;

import java.math.BigDecimal;

public class GrouponIndex {

    private Goods goods;

    private int groupon_member;

    private BigDecimal groupon_price;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(int groupon_member) {
        this.groupon_member = groupon_member;
    }

    public BigDecimal getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(BigDecimal groupon_price) {
        this.groupon_price = groupon_price;
    }
}
