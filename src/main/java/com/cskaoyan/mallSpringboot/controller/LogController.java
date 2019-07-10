package com.cskaoyan.mallSpringboot.controller;

import com.cskaoyan.mallSpringboot.bean.*;
import com.cskaoyan.mallSpringboot.gss_vo.ErrorVo;
import com.cskaoyan.mallSpringboot.gss_vo.dashboard.DashboardData;
import com.cskaoyan.mallSpringboot.gss_vo.dashboard.DashboardVo;
import com.cskaoyan.mallSpringboot.gss_vo.data.DashBoardData;
import com.cskaoyan.mallSpringboot.gss_vo.generalvo.GeneralVo;
import com.cskaoyan.mallSpringboot.mapper.*;
import com.cskaoyan.mallSpringboot.service.shiro.ShiroService;
import com.cskaoyan.mallSpringboot.service.shiro.impl.ShiroServiceImpl;
import com.cskaoyan.mallSpringboot.utils.MD5Util;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class LogController {

    ResponseVo responseVo;

    private static LoginUser loginUser2 = new LoginUser();

    @RequestMapping("admin/auth/login")
    @ResponseBody
    public ResponseVo login(@RequestBody LoginUser loginUser){

        Subject subject = SecurityUtils.getSubject();
        ResponseVo responseVo = new ResponseVo();
        try {
            String encode = MD5Util.encode(loginUser.getPassword());
            loginUser.setPassword(encode);
            subject.login(new UsernamePasswordToken(loginUser.getUsername(), loginUser.getPassword()));

            loginUser2.setUsername(loginUser.getUsername());
            loginUser2.setPassword(loginUser.getPassword());

            responseVo.setErrno(0);
            responseVo.setData(subject.getSession().getId());

            responseVo.setErrmsg("成功");
            loginUser2 = loginUser;
            return responseVo;
        }catch (Exception e){
            return responseVo;
        }

    }
    @Autowired
    ShiroService shiroService;

    @RequestMapping("admin/auth/info")
    @ResponseBody
    public ResponseVo dashboard(){
        //然后再根据loginUser2去拿到数据库中对应的管理员的信息，并且填入到ResponseVo中

        GeneralVo<DashBoardData> operatorInfo = new GeneralVo<>();

        DashBoardData dashBoardData = new DashBoardData();
        dashBoardData.setName(loginUser2.getUsername());

        //需要将该管理用户对应的角色名从数据库中取出

        Admin admin = shiroService.getSingleAdminByUserName(loginUser2.getUsername());
        List<String> perms = shiroService.getAllPermission(admin.getRoleIds());
        List<String> rolesInName = shiroService.getAllRolesInChinese(admin.getRoleIds());

        ResponseVo responseVo = new ResponseVo();
        responseVo.setErrno(0);
        HashMap<String, Object> para = new HashMap<>();

        para.put("perms", perms);


        para.put("roles", rolesInName);
        para.put("name", admin.getUsername());
        para.put("avatar", admin.getAvatar());
        responseVo.setData(para);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    GoodsproductMapper goodsproductMapper;
    @Autowired
    UserMapper userMapper;

    @RequestMapping("admin/dashboard")
    @ResponseBody
    public DashboardVo getBaseInfo() {
        DashboardVo dashboardVo = new DashboardVo();
        DashboardData dashboardData = new DashboardData();

        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.getAllCriteria();
        dashboardData.setGoodsTotal(goodsMapper.countByExample(goodsExample));

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria1 = orderExample.createCriteria();
        criteria1.getAllCriteria();
        dashboardData.setOrderTotal(orderMapper.countByExample(orderExample));

        GoodsproductExample goodsproductExample = new GoodsproductExample();
        GoodsproductExample.Criteria criteria2 = goodsproductExample.createCriteria();
        criteria2.getAllCriteria();
        dashboardData.setProductTotal(goodsproductMapper.countByExample(goodsproductExample));

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria3 = userExample.createCriteria();
        criteria3.getAllCriteria();
        dashboardData.setUserTotal(userMapper.countByExample(userExample));

        dashboardVo.setErrno(0);
        dashboardVo.setErrmsg("成功");
        dashboardVo.setData(dashboardData);
        return dashboardVo;
/*=======
    @RequestMapping("log/list")
    public ResponseVo queryList(int page,int limit,String admin){
        responseVo=new ResponseVo();
        responseVo=logService.queryList(page,limit,admin);
        return responseVo;
>>>>>>> 0a364ec252052fb29577c8a264e5be7e1a389acd
    }*/
    }
}
