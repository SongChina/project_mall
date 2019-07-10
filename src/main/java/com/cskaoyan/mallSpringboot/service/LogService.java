package com.cskaoyan.mallSpringboot.service;


import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface LogService {
    ResponseVo queryList(int page, int limit, String admin);
}
