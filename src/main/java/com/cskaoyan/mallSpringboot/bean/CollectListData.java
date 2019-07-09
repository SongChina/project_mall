package com.cskaoyan.mallSpringboot.bean;

import java.util.List;

public class CollectListData {
    List<CollectData> collectList;
    int   totalPages;

    public List<CollectData> getCollectList() {
        return collectList;
    }

    public void setCollectList(List<CollectData> collectList) {
        this.collectList = collectList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
