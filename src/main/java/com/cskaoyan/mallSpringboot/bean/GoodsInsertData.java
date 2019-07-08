package com.cskaoyan.mallSpringboot.bean;


import java.util.List;

public class GoodsInsertData {
    private GoodsInWeb goods;
    private List<AttributeInWeb>  attributes;
    private List<ProductsInWeb> products;
    private List<SpecificationsInWeb> specifications;

    public GoodsInWeb getGoods() {
        return goods;
    }

    public void setGoods(GoodsInWeb goods) {
        this.goods = goods;
    }

    public List<AttributeInWeb> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeInWeb> attributes) {
        this.attributes = attributes;
    }

    public List<ProductsInWeb> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsInWeb> products) {
        this.products = products;
    }


    public List<SpecificationsInWeb> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<SpecificationsInWeb> specifications) {
        this.specifications = specifications;
    }
}
