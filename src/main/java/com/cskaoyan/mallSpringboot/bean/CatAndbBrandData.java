package com.cskaoyan.mallSpringboot.bean;

import java.util.List;

public class CatAndbBrandData {
    List<BrandData> brandList;

    List<CategoryData> categoryList;

    public List<BrandData> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandData> brandList) {
        this.brandList = brandList;
    }

    public List<CategoryData> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryData> categoryList) {
        this.categoryList = categoryList;
    }

    public CatAndbBrandData() {
    }

    public CatAndbBrandData(List<BrandData> brandList, List<CategoryData> categoryList) {
        this.brandList = brandList;
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "CatAndbBrandData{" +
                "brandList=" + brandList +
                ", categoryList=" + categoryList +
                '}';
    }
}
