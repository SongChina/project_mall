package com.cskaoyan.mallSpringboot.service.shiro;

import com.cskaoyan.mallSpringboot.bean.Admin;

import java.util.List;

public interface ShiroService {
    //需要根据登录管理员的roleId[]从permission表中取出具体的权限
    List<String> getAllPermission(int[] roleIds);

    Admin getSingleAdminByUserName(String username);

    List<String> getAllRolesInChinese(int[] roleIds);
}
