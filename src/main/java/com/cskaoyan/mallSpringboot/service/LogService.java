package com.cskaoyan.mallSpringboot.service;

import com.cskaoyan.mallSpringboot.renguopingVO.ResponseVo;

public interface LogService {
    ResponseVo queryList(int page,int limit,String admin);
}
