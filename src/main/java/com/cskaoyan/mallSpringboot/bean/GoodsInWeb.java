package com.cskaoyan.mallSpringboot.bean;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsInWeb {
    private Integer id;

    private String goodsSn;

    private String name;

    private Integer categoryId;

    private Integer brandId;

    private String[] gallery;

    private String keywords;

    private String brief;

    private boolean isOnSale;

    private Short sortOrder;

    private String picUrl;

    private String shareUrl;

    private boolean isNew;

    private boolean isHot;

    private String unit;

    private BigDecimal counterPrice;

    private BigDecimal retailPrice;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String[] getGallery() {
        return gallery;
    }

    public void setGallery(String[] gallery) {
        this.gallery = gallery;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public boolean getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    public Short getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(boolean isHot) {
        this.isHot = isHot;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(BigDecimal counterPrice) {
        this.counterPrice = counterPrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
