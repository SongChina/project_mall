package com.cskaoyan.mallSpringboot.service.personalcenter;

import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface CouponDataService {
    ResponseVo couponList(int status,int page, int size);
}
