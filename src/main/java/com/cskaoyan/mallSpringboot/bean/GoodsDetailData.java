package com.cskaoyan.mallSpringboot.bean;

import java.util.Arrays;
import java.util.List;

public class GoodsDetailData {
    List<Goodsattribute>  attributes;
    Integer[] categoryIds;
    Goods goods;
    List<Goodsproduct> products;
    List<Goodsspecification> specifications;

    public List<Goodsattribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Goodsattribute> attributes) {
        this.attributes = attributes;
    }

    public Integer[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Integer[] categoryIds) {
        this.categoryIds = categoryIds;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<Goodsproduct> getProducts() {
        return products;
    }

    public void setProducts(List<Goodsproduct> products) {
        this.products = products;
    }

    public List<Goodsspecification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Goodsspecification> specifications) {
        this.specifications = specifications;
    }

    public GoodsDetailData() {
    }

    public GoodsDetailData(List<Goodsattribute> attributes, Integer[] categoryIds, Goods goods, List<Goodsproduct> products, List<Goodsspecification> specifications) {
        this.attributes = attributes;
        this.categoryIds = categoryIds;
        this.goods = goods;
        this.products = products;
        this.specifications = specifications;
    }

    @Override
    public String toString() {
        return "GoodsDetailData{" +
                "attributes=" + attributes +
                ", categoryIds=" + Arrays.toString(categoryIds) +
                ", goods=" + goods +
                ", products=" + products +
                ", specifications=" + specifications +
                '}';
    }
}
