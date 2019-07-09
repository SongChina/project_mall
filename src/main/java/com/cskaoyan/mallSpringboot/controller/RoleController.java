package com.cskaoyan.mallSpringboot.controller;

import com.cskaoyan.mallSpringboot.bean.Role;
import com.cskaoyan.mallSpringboot.renguopingVO.ResponseVo;
import com.cskaoyan.mallSpringboot.service.admin.RoleService;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    ResponseVo responseVo;

    public static final JsonObject jsonObject = new JsonObject();


    @RequestMapping("role/options")
    public ResponseVo queryOption(){
        responseVo=new ResponseVo();
        responseVo=roleService.queryOption();
        return responseVo;
    }

    @RequestMapping("role/list")
    public ResponseVo queryList(int page,int limit,String name, String sort, String order){
        responseVo=new ResponseVo();
        responseVo=roleService.queryList(page,limit,name,sort, order);
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

   /* @RequestMapping("role/permissions")
    public JsonObject getAll(){
        return init();
    }*/





}
