package com.cskaoyan.mallSpringboot.controller.user;

import com.cskaoyan.mallSpringboot.bean.IndexData;
import com.cskaoyan.mallSpringboot.bean.IndexOrder;
import com.cskaoyan.mallSpringboot.bean.LoginResponseData;
import com.cskaoyan.mallSpringboot.bean.UserInfo;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("wx")
public class LoginController {

    @RequestMapping("auth/login")
    public ResponseVo login(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAvatarUrl("");
        userInfo.setNickName("admin123");
        LoginResponseData loginResponseData = new LoginResponseData();
        loginResponseData.setToken("ou2zmcftgk8u1hwiy6092w6ywsxvnt1s");
        loginResponseData.setTokenExpire(System.currentTimeMillis());
        loginResponseData.setUserInfo(userInfo);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        responseVo.setData(loginResponseData);
        return responseVo;
    }

    @RequestMapping("user/index")
    public ResponseVo userIndex(){
        IndexOrder indexOrder = new IndexOrder();
        indexOrder.setUncomment(1);
        indexOrder.setUnpaid(0);
        indexOrder.setUnrecv(0);
        indexOrder.setUnship(0);
        IndexData indexData = new IndexData();
        indexData.setOrder(indexOrder);
        return new ResponseVo(0,indexData,"成功");


    }

}
