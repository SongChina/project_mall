package com.cskaoyan.mallSpringboot.gss_vo;

import java.util.List;

public class StatisticsData<T> {
    private String[] Columns;
    private List<T> rows;

    public String[] getColumns() {
        return Columns;
    }

    public void setColumns(String[] columns) {
        Columns = columns;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
