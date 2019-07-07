package com.cskaoyan.mallSpringboot.service;

import com.cskaoyan.mallSpringboot.bean.Admin;
import com.cskaoyan.mallSpringboot.bean.AdminInWeb;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminServcie {
    //查询所有管理员
    List<Admin> queryAllAdmins();

    //增加管理员
    int insertAdmin(AdminInWeb adminInWeb);

    //编辑管理员
    int updateAdmin(Admin admin);

    //删除管理员
    int deleteAdmin(Integer id);

    //根据名字模糊查询
    List<Admin> queryAdminByName(String username);
}
