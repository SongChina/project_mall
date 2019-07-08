package com.cskaoyan.mallSpringboot.controller;

import com.cskaoyan.mallSpringboot.bean.Admin;
import com.cskaoyan.mallSpringboot.bean.AdminInWeb;
import com.cskaoyan.mallSpringboot.renguopingVO.ResponseVo;
import com.cskaoyan.mallSpringboot.renguopingVO.ResultVo;
import com.cskaoyan.mallSpringboot.service.AdminServcie;


import com.cskaoyan.mallSpringboot.utils.MD5Util;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AdminController {

    @Autowired
    AdminServcie adminServcie;
    ResponseVo responseVo;
    ResultVo resultVo;


    @RequestMapping("admin/list")
    public ResponseVo queryAdmins(int page,int limit,String username){
        resultVo = new ResultVo();
        responseVo = new ResponseVo();
        //获取列表
        if(username==null) {
            PageHelper.startPage(page,limit);
            List<Admin> admins = adminServcie.queryAllAdmins();
            resultVo.setItems(admins);
            resultVo.setTotal(admins.size());
            responseVo.setErrno(0);
            responseVo.setData(resultVo);
            responseVo.setErrmsg("成功");
        //根据名字模糊查询
        }else{
            PageHelper.startPage(page,limit);
            List<Admin> admins=adminServcie.queryAdminByName(username);
            resultVo.setItems(admins);
            resultVo.setTotal(admins.size());
            responseVo.setErrno(0);
            responseVo.setData(resultVo);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }

    //添加管理员
    @RequestMapping("admin/create")
    public ResponseVo insertAdmin(@RequestBody AdminInWeb adminInWeb){
        String s= MD5Util.encode(adminInWeb.getPassword());
        adminInWeb.setPassword(s);
        responseVo = new ResponseVo();
        int insert=adminServcie.insertAdmin(adminInWeb);
        if(insert!=0){
            responseVo.setErrno(0);
            responseVo.setData(adminInWeb);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }
    //更新管理员
    @RequestMapping("admin/update")
    public ResponseVo updateAdmin(@RequestBody Admin admin){
        String s= MD5Util.encode(admin.getPassword());
        admin.setPassword(s);
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
