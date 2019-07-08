package com.cskaoyan.mallSpringboot.service;

import com.cskaoyan.mallSpringboot.bean.Admin;
import com.cskaoyan.mallSpringboot.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AdminServcieImpl implements AdminServcie {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> queryAllAdmins() {
        return adminMapper.queryAllAdmins();
    }

    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public int deleteAdmin(Integer id) {
        return adminMapper.deleteAdmin(id);
    }

    @Override
    public List<Admin> queryAdminByName(String username) {
        return adminMapper.queryAdminByName(username);
    }
}
