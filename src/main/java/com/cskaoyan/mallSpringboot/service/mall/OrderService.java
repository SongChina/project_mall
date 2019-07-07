package com.cskaoyan.mallSpringboot.service.mall;

import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface OrderService {
    ResponseVo orderList(QueryIn queryIn, String[] orderStatusArray, String orderSn, String userId);

    ResponseVo orderDetail(String id);
}
