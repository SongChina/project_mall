package com.cskaoyan.mallSpringboot.controller.personalcenter;


import com.cskaoyan.mallSpringboot.service.personalcenter.*;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PersonalCenterController {
    @Autowired
    CouponDataService couponDataService;
    @Autowired
    CollectListService collectListService;
    @Autowired
    FootprintListService footprintListService;
    @Autowired
    AddressListService addressListService;
//    @Autowired
//    OrderListService orderListService;

    @RequestMapping("wx/coupon/mylist")
    public ResponseVo couponList(int status,int page,int size, HttpServletRequest request){
        ResponseVo responseVo = couponDataService.couponList(status, page, size, request);
        return responseVo;
    }

    @RequestMapping("wx/collect/list")
    public ResponseVo collectList(int type,int page,int size, HttpServletRequest request){
        ResponseVo responseVo = collectListService.collectList(type,page,size,request);
        return responseVo;
    }

    @RequestMapping("wx/footprint/list")
    public ResponseVo footprintList(int page, int size , HttpServletRequest request){
        ResponseVo responseVo =footprintListService.footprintList(page,size,request);
        return responseVo;
    }

/*    @RequestMapping("wx/address/list")
    public ResponseVo addressList(){
        ResponseVo responseVo = addressListService.addressList();
        return responseVo;
    }*/
    @RequestMapping("wx/coupon/exchange")
    public ResponseVo exchange(){
        return new ResponseVo(742,"","优惠券不正确");
    }

    /*@RequestMapping("wx/order/list")
    public ResponseVo orderShowType(int showType, int page, int size, HttpServletRequest request){
        ResponseVo responseVo = orderListService.orderShowType(showType,page,size,request);
        return  responseVo;
    }*/
}
