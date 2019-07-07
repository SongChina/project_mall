package com.cskaoyan.mallSpringboot.service.promotion;

import com.cskaoyan.mallSpringboot.bean.Coupon;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

import java.util.Date;

public interface CouponService {
    Coupon createCoupon(Coupon coupon);//增
    int delete(Integer id, Date updateTime);//删
    int update(Coupon coupon);//改
    ResponseVo queryList(QueryIn queryIn, String name, String type, String status);//查
}
