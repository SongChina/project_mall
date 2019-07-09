package com.cskaoyan.mallSpringboot.controller.personalcenter;


import com.cskaoyan.mallSpringboot.service.personalcenter.AddressListService;
import com.cskaoyan.mallSpringboot.service.personalcenter.CollectListService;
import com.cskaoyan.mallSpringboot.service.personalcenter.CouponDataService;
import com.cskaoyan.mallSpringboot.service.personalcenter.FootprintListService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("wx/coupon/mylist")
    public ResponseVo couponList(int status,int page,int size){
        ResponseVo responseVo = couponDataService.couponList(status, page, size);
        return responseVo;
    }

    @RequestMapping("wx/collect/list")
    public ResponseVo collectList(int type,int page,int size){
        ResponseVo responseVo = collectListService.collectList(type,page,size);
        return responseVo;
    }

    @RequestMapping("wx/footprint/list")
    public ResponseVo footprintList(int page, int size ){
        ResponseVo responseVo =footprintListService.footprintList(page,size);
        return responseVo;
    }

    @RequestMapping("wx/address/list")
    public ResponseVo addressList(){
        ResponseVo responseVo = addressListService.addressList();
        return responseVo;
    }
}
