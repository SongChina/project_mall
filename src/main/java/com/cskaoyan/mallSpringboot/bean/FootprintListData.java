package com.cskaoyan.mallSpringboot.bean;

import java.util.List;

public class FootprintListData {
    List<FootprintData> footprintList;
    int totalPage;

    public List<FootprintData> getFootprintList() {
        return footprintList;
    }

    public void setFootprintList(List<FootprintData> footprintList) {
        this.footprintList = footprintList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
