package com.cskaoyan.mallSpringboot.service.personalcenter;

import com.cskaoyan.mallSpringboot.vo.ResponseVo;

import javax.servlet.http.HttpServletRequest;

public interface FootprintListService {
    ResponseVo footprintList(int page, int size, HttpServletRequest request);
}
