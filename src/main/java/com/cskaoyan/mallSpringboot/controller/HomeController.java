package com.cskaoyan.mallSpringboot.controller;

import com.cskaoyan.mallSpringboot.service.goods.GoodsListService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    GoodsListService goodsListService;

    //获取微信首页所有信息
    @RequestMapping("home/index")
    public ResponseVo getHomeIndexMessage(){
        ResponseVo responseVo = goodsListService.getHomeIndexMessage();
        return responseVo;
    }
}
