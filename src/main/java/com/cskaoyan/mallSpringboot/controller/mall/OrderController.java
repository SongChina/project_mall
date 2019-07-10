package com.cskaoyan.mallSpringboot.controller.mall;

import com.cskaoyan.mallSpringboot.service.mall.OrderService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    //查询订单
    @RequestMapping("admin/order/list")
    public ResponseVo OrderList(QueryIn queryIn, String[] orderStatusArray, String orderSn, String userId){
        ResponseVo responseVo = orderService.orderList(queryIn, orderStatusArray, orderSn, userId);
        return responseVo;
    }
    //查询订单详情
    @RequestMapping("admin/order/detail")
    public ResponseVo OrderDetail(String id){
        ResponseVo responseVo = orderService.orderDetail(id);
        return responseVo;
    }
}
