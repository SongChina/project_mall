package com.cskaoyan.mallSpringboot.service.mall;

import com.cskaoyan.mallSpringboot.bean.Brand;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

import java.util.Map;

public interface BrandService {
    ResponseVo queryBrandList(QueryIn queryIn, String id, String name);

    ResponseVo brandCreate(Brand brand);

    Map brandDelete(Brand brand);

    ResponseVo brandUpdate(Brand brand);

    ResponseVo brandDetail(String id);

    ResponseVo queryWXBrandList(int page, int size);
}
