package com.cskaoyan.mallSpringboot.service.mall;

import com.cskaoyan.mallSpringboot.bean.Brand;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface BrandService {
    ResponseVo queryBrandList(QueryIn queryIn, String id, String name);

    ResponseVo brandCreate(Brand brand);

    ResponseVo brandDelete(Brand brand);

    ResponseVo brandUpdate(Brand brand);
}
