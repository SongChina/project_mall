package com.cskaoyan.mallSpringboot.service.personalcenter;

import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface FootprintListService {
    ResponseVo footprintList(int page, int size);
}
