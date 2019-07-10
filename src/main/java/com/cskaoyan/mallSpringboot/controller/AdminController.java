package com.cskaoyan.mallSpringboot.controller;

import com.cskaoyan.mallSpringboot.bean.Admin;
import com.cskaoyan.mallSpringboot.renguopingVO.ResponseVo;
import com.cskaoyan.mallSpringboot.renguopingVO.ResultVo;
import com.cskaoyan.mallSpringboot.service.admin.AdminServcie;


import com.cskaoyan.mallSpringboot.utils.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("admin/")
public class AdminController {

    @Autowired
    AdminServcie adminServcie;

    ResponseVo responseVo;
    ResultVo resultVo;


    @RequestMapping("admin/list")
    @RequiresPermissions("admin:admin:list")
    public ResponseVo queryAdmins(int page,int limit,String username){
        resultVo = new ResultVo();
        responseVo = new ResponseVo();
        //获取列表
        if(username==null) {
            PageHelper.startPage(page,limit);
            List<Admin> admins = adminServcie.queryAllAdmins();
            PageInfo<Admin> pageInfo = new PageInfo<>(admins);
            resultVo.setItems(pageInfo.getList());
            resultVo.setTotal((int) pageInfo.getTotal());

        //根据名字模糊查询
        }else{
            PageHelper.startPage(page,limit);
            List<Admin> admins=adminServcie.queryAdminByName(username);
            PageInfo<Admin> pageInfo = new PageInfo<>(admins);
            resultVo.setItems(pageInfo.getList());
            resultVo.setTotal((int) pageInfo.getTotal());
        }
        responseVo.setErrno(0);
        responseVo.setData(resultVo);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

    //添加管理员
    @RequestMapping("admin/create")
    @RequiresPermissions("admin:admin:create")
    public ResponseVo insertAdmin(@RequestBody Admin admin){
        responseVo = new ResponseVo();
        String s= MD5Util.encode(admin.getPassword());
        admin.setPassword(s);
        admin.setAddTime(new Date());
        admin.setUpdateTime(new Date());
        admin.setDeleted(false);
        int insert=adminServcie.insertAdmin(admin);
        if(insert!=0){
            responseVo.setErrno(0);
            responseVo.setData(admin);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }
    //更新管理员
    @RequestMapping("admin/update")
    @RequiresPermissions("admin:admin:update")
    public ResponseVo updateAdmin(@RequestBody Admin admin){
        String s= MD5Util.encode(admin.getPassword());
        admin.setPassword(s);
        admin.setUpdateTime(new Date());
        responseVo = new ResponseVo();
        int update=adminServcie.updateAdmin(admin);
        if(update!=0){
            responseVo.setErrno(0);
            responseVo.setData(admin);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }
    //删除管理员
    @RequestMapping("admin/delete")
    @RequiresPermissions("admin:admin:delete")
    public ResponseVo deleteAdmin(@RequestBody Admin admin){
        responseVo = new ResponseVo();
        int delete=adminServcie.deleteAdmin(admin.getId());
        if(delete!=0){
            responseVo.setErrno(0);
            responseVo.setData(null);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }

}
