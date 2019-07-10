package com.cskaoyan.mallSpringboot.service.personalcenter;


import com.cskaoyan.mallSpringboot.vo.ResponseVo;

import javax.servlet.http.HttpServletRequest;

public interface CollectListService {
    ResponseVo collectList(int type,int page,int size, HttpServletRequest request);
}
