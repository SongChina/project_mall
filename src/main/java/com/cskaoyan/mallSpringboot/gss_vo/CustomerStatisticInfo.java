package com.cskaoyan.mallSpringboot.gss_vo;

import java.util.Date;

public class CustomerStatisticInfo {
    private Date day;
    private int users;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }
}
