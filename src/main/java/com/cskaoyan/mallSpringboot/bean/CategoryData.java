package com.cskaoyan.mallSpringboot.bean;

import java.util.List;

public class CategoryData {
    String value;
    String label;
    List<CategoryData> children;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<CategoryData> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryData> children) {
        this.children = children;
    }

    public CategoryData() {
    }

    public CategoryData(String value, String label, List<CategoryData> children) {
        this.value = value;
        this.label = label;
        this.children = children;
    }

    @Override
    public String toString() {
        return "CategoryData{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
