package com.cskaoyan.mallSpringboot.service.promotion;

import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface CouponuserService {

    ResponseVo queryList(QueryIn queryIn, String couponId, String userId, String status);//查

}
