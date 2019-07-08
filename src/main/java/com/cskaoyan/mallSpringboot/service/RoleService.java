package com.cskaoyan.mallSpringboot.service;

import com.cskaoyan.mallSpringboot.bean.Role;

import java.util.List;

public interface RoleService {
    //查询所有角色
    List<Role> queryAllRole();
}
