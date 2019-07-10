package com.cskaoyan.mallSpringboot.controller;

import com.cskaoyan.mallSpringboot.service.WxOrderService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WxOrderController {
    @Autowired
    WxOrderService wxOrderService;

    ResponseVo responseVo;

    @RequestMapping("wx/order/list")
    public ResponseVo queryList(HttpServletRequest request,int showType, int page, int size){
        responseVo=new ResponseVo();
        responseVo=wxOrderService.queryList(request,showType,page,size);
        return responseVo;
    }

}
