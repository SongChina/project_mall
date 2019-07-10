package com.cskaoyan.mallSpringboot.service.personalcenter;

import com.cskaoyan.mallSpringboot.vo.ResponseVo;

import javax.servlet.http.HttpServletRequest;

public interface OrderListService {
    ResponseVo orderShowType(int showType, int page, int size, HttpServletRequest request);
}
