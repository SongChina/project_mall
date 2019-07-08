package com.cskaoyan.mallSpringboot.controller;

import com.cskaoyan.mallSpringboot.bean.Role;
import com.cskaoyan.mallSpringboot.renguopingVO.ResponseVo;
import com.cskaoyan.mallSpringboot.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    ResponseVo responseVo;

    @RequestMapping("role/options")
    public ResponseVo queryOption(){
        responseVo=new ResponseVo();
        responseVo=roleService.queryOption();
        return responseVo;
    }

    @RequestMapping("role/list")
    public ResponseVo queryList(int page,int limit,String name){
        responseVo=new ResponseVo();
        responseVo=roleService.queryList(page,limit,name);
        return responseVo;
    }

    @RequestMapping("role/create")
    public ResponseVo insertRole(@RequestBody Role role){
        responseVo=new ResponseVo();
        responseVo=roleService.insertRole(role);
        return  responseVo;
    }

    @RequestMapping("role/update")
    public ResponseVo updateRole(@RequestBody Role role){
        responseVo=new ResponseVo();
        responseVo=roleService.updateRole(role);
        return responseVo;
    }

    @RequestMapping("role/delete")
    public ResponseVo deleteRole(@RequestBody Role role){
        responseVo=new ResponseVo();
        responseVo=roleService.deleteRole(role.getId());
        return responseVo;
    }






}
