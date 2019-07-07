package com.cskaoyan.mallSpringboot.service;

import com.cskaoyan.mallSpringboot.bean.Role;
import com.cskaoyan.mallSpringboot.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> queryAllRole() {
        return roleMapper.queryAllRole();
    }
}
