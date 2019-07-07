package com.cskaoyan.mallSpringboot.bean;

import java.util.Arrays;

public class GoodsInsertData {
    private Goods goods;
    private Goodsattribute[] attributes;
    private Goodsproduct[] products;
    private Goodsspecification[] specifications;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Goodsattribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Goodsattribute[] attributes) {
        this.attributes = attributes;
    }

    public Goodsproduct[] getProducts() {
        return products;
    }

    public void setProducts(Goodsproduct[] products) {
        this.products = products;
    }

    public Goodsspecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Goodsspecification[] specifications) {
        this.specifications = specifications;
    }

    @Override
    public String toString() {
        return "GoodsInsertData{" +
                "goods=" + goods +
                ", attributes=" + Arrays.toString(attributes) +
                ", products=" + Arrays.toString(products) +
                ", specifications=" + Arrays.toString(specifications) +
                '}';
    }
}
