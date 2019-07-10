package com.cskaoyan.mallSpringboot.gss_vo.dashboard;

public class DashboardData {
    private long goodsTotal;
    private long userTotal;
    private long productTotal;
    private long orderTotal;

    public long getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(long goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    public long getUserTotal() {
        return userTotal;
    }

    public void setUserTotal(long userTotal) {
        this.userTotal = userTotal;
    }

    public long getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(long productTotal) {
        this.productTotal = productTotal;
    }

    public long getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(long orderTotal) {
        this.orderTotal = orderTotal;
    }
}
