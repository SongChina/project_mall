package com.cskaoyan.mallSpringboot.controller;

import com.cskaoyan.mallSpringboot.bean.Role;
import com.cskaoyan.mallSpringboot.renguopingVO.OptionVo;
import com.cskaoyan.mallSpringboot.renguopingVO.ResponseVo;
import com.cskaoyan.mallSpringboot.renguopingVO.ResultVo;
import com.cskaoyan.mallSpringboot.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    ResponseVo responseVo;
    ResultVo resultVo;
    OptionVo optionVo;

    @RequestMapping("role/options")
    public ResponseVo queryOption(){
        responseVo=new ResponseVo();
        List<OptionVo> data=new ArrayList();
        List<Role> roles=roleService.queryAllRole();
        for(Role role:roles) {
            optionVo=new OptionVo();
            optionVo.setValue(role.getId());
            optionVo.setLabel(role.getName());
            data.add(optionVo);
        }
        responseVo.setErrno(0);
        responseVo.setData(data);
        responseVo.setErrmsg("成功");
        return responseVo;
    }
    @RequestMapping("role/list")
    public ResponseVo queryAllRole(){
        responseVo=new ResponseVo();
        resultVo=new ResultVo();
        List<Role> roles=roleService.queryAllRole();
        resultVo.setTotal(roles.size());
        resultVo.setItems(roles);
        responseVo.setErrno(0);
        responseVo.setData(resultVo);
        responseVo.setErrmsg("成功");
        return responseVo;
    }



}
