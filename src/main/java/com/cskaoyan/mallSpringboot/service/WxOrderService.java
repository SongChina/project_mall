package com.cskaoyan.mallSpringboot.service;

import com.cskaoyan.mallSpringboot.vo.ResponseVo;

import javax.servlet.http.HttpServletRequest;

public interface WxOrderService {
    ResponseVo queryList(HttpServletRequest request,int page, int size, int showType);
}
