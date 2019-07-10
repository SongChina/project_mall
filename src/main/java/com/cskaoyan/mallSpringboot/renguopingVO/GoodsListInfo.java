package com.cskaoyan.mallSpringboot.renguopingVO;

public class GoodsListInfo {
    Integer id;//goods's id
    String goodsName;
    Short number;
    String picUrl;

    public GoodsListInfo() {
    }

    public GoodsListInfo(Integer id, String goodsName, Short number, String picUrl) {
        this.id = id;
        this.goodsName = goodsName;
        this.number = number;
        this.picUrl = picUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(Short number) {
        this.number = number;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
