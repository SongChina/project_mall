package com.cskaoyan.mallSpringboot.controller;

import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LogController {


    @RequestMapping("admin/auth/login")
    public ResponseVo login(){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setErrno(0);
        responseVo.setData("02514c8b-4124-4a95-b513-e77ef43403ba");
        responseVo.setErrmsg("成功");
        return responseVo;
    }
    @RequestMapping("admin/auth/info")
    public ResponseVo dashboard(){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setErrno(0);
        HashMap<String, Object> para = new HashMap<>();
        para.put("perms", "*");
        para.put("roles", "超级管理员");
        para.put("name", "admin123");
        para.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        responseVo.setData(para);
        responseVo.setErrmsg("成功");
        return responseVo;
    }
}
