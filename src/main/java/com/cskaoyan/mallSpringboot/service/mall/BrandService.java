package com.cskaoyan.mallSpringboot.service.mall;

import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface BrandService {
    ResponseVo queryBrandList(QueryIn queryIn, String id, String name);
}
