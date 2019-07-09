package com.cskaoyan.mallSpringboot.bean;

import java.util.List;

public class GrouponActivity {
    private Goods2 goods;
    private Groupon groupon;
    private Grouponrules rules;
    private List<Groupon> subGroupons;

    public Goods2 getGoods() {
        return goods;
    }

    public void setGoods(Goods2 goods) {
        this.goods = goods;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public Grouponrules getRules() {
        return rules;
    }

    public void setRules(Grouponrules rules) {
        this.rules = rules;
    }

    public List<Groupon> getSubGroupons() {
        return subGroupons;
    }

    public void setSubGroupons(List<Groupon> subGroupons) {
        this.subGroupons = subGroupons;
    }

    @Override
    public String toString() {
        return "GrouponActivity{" +
                "goods=" + goods +
                ", groupon=" + groupon +
                ", rules=" + rules +
                ", subGroupons=" + subGroupons +
                '}';
    }
}