package com.cskaoyan.mallSpringboot.bean;

public class AdminInWeb {
    private String username;
    private String password;
    private int[] roleIds;

    public AdminInWeb(String username, String password, int[] roleIds) {
        this.username = username;
        this.password = password;
        this.roleIds = roleIds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(int[] roleIds) {
        this.roleIds = roleIds;
    }
}
