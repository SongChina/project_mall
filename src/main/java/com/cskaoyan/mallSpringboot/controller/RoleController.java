package com.cskaoyan.mallSpringboot.controller;

import com.cskaoyan.mallSpringboot.bean.Role;
import com.cskaoyan.mallSpringboot.bean.systempermission.Data;
import com.cskaoyan.mallSpringboot.bean.systempermission.Data_;
import com.cskaoyan.mallSpringboot.gss_vo.RolePermissionVo;
import com.cskaoyan.mallSpringboot.renguopingVO.ResponseVo;
import com.cskaoyan.mallSpringboot.service.admin.RoleService;

import com.cskaoyan.mallSpringboot.service.permission.PermissionService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
public class RoleController {
    public static final Data data;
    static {
        File file = new File("src/main/resources/data.json");
        String content = null;
        try {
            content = FileUtils.readFileToString(file, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        data= gson.fromJson(content, Data.class);
    }
    @Autowired
    RoleService roleService;

    ResponseVo responseVo;



    public static final JsonObject jsonObject = new JsonObject();


    @RequestMapping("admin/role/options")
    public ResponseVo queryOption(){
        responseVo=new ResponseVo();
        responseVo=roleService.queryOption();
        return responseVo;
    }

    @RequestMapping("admin/role/list")
    public ResponseVo queryList(int page,int limit,String name, String sort, String order){
        responseVo=new ResponseVo();
        responseVo=roleService.queryList(page,limit,name,sort, order);
        return responseVo;
    }

    @RequestMapping("admin/role/create")
    public ResponseVo insertRole(@RequestBody Role role){
        responseVo=new ResponseVo();
        responseVo=roleService.insertRole(role);
        return  responseVo;
    }

    @RequestMapping("admin/role/update")
    public ResponseVo updateRole(@RequestBody Role role){
        responseVo=new ResponseVo();
        responseVo=roleService.updateRole(role);
        return responseVo;
    }

    @RequestMapping("admin/role/delete")
    public ResponseVo deleteRole(@RequestBody Role role){
        responseVo=new ResponseVo();
        responseVo=roleService.deleteRole(role.getId());
        return responseVo;
    }


    @GetMapping("admin/role/permissions")
    public Data getPermissionInfo(int roleId){
        //将对应的角色的权限查出来
        List<String> assignedPermissions = roleService.queryRoleRightsInRoleId(roleId);
        Data_ data1 = RoleController.data.getData();
        data1.setAssignedPermissions(assignedPermissions);
        return data;
    }

    @Autowired
    PermissionService permissionService;
    @PostMapping("admin/role/permissions")
    public ResponseVo updatePermissions(@RequestBody RolePermissionVo rolePermissionVo){
        boolean flag = permissionService.updatePermissionsByRoleId(rolePermissionVo.getRoleId(), rolePermissionVo.getPermissions());
        ResponseVo responseVo = new ResponseVo();
        if(flag){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }
}
