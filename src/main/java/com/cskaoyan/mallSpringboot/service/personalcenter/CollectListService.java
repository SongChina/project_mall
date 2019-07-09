package com.cskaoyan.mallSpringboot.service.personalcenter;


import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface CollectListService {
    ResponseVo collectList(int type,int page,int size);
}
