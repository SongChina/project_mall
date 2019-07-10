package com.cskaoyan.mallSpringboot.service.shiro.impl;

import com.cskaoyan.mallSpringboot.bean.*;
import com.cskaoyan.mallSpringboot.bean.Permission;
import com.cskaoyan.mallSpringboot.mapper.AdminMapper;
import com.cskaoyan.mallSpringboot.mapper.PermissionMapper;
import com.cskaoyan.mallSpringboot.mapper.RoleMapper;
import com.cskaoyan.mallSpringboot.service.shiro.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<String> getAllPermission(int[] roleIds) {
        List<Integer> ids = new ArrayList<>();
        PermissionExample permissionExample = new PermissionExample();
        PermissionExample.Criteria criteria1 = permissionExample.createCriteria();
        for (int roleId : roleIds) {
            //将对应的角色
            ids.add(roleId);
        }
        criteria1.andRoleIdIn(ids);
        List<Permission> permissions = permissionMapper.selectByExample(permissionExample);
        List<String> perms = new ArrayList<>();
        for (Permission permission : permissions) {
            String prefix;
            String temp = permission.getPermission();
            if (!"*".equals(temp)) {
                if (temp.endsWith("read") || temp.endsWith("list")) {
                    prefix = "GET /";
                } else {
                    prefix = "POST /";
                }
                String replace = temp.replace(':', '/');
                temp.replaceAll(":", "/");
                perms.add(prefix + replace);
            } else {
                perms.add(temp);
                break;
            }
        }
        return perms;
    }

    @Override
    public Admin getSingleAdminByUserName(String username) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        Admin admin = admins.get(0);
        return admin;
    }

    @Override
    public List<String> getAllRolesInChinese(int[] roleIds) {
        List<Integer> ids = new ArrayList<>();
        for (int roleId : roleIds) {
            //将对应的角色
            ids.add(roleId);
        }
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria2 = roleExample.createCriteria();
        criteria2.andIdIn(ids);
        List<Role> roles = roleMapper.selectByExample(roleExample);
        List<String> rolesInName = new ArrayList<>();
        for (Role role : roles) {
            rolesInName.add(role.getName());
        }

        return rolesInName;
    }
}
