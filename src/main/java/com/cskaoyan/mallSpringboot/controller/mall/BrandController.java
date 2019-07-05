package com.cskaoyan.mallSpringboot.controller.mall;

import com.cskaoyan.mallSpringboot.service.mall.BrandService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController {

    @Autowired
    BrandService brandService;

    @RequestMapping("brand/list")
    public ResponseVo brand(QueryIn queryIn, String id, String name){
        ResponseVo responseVo = brandService.queryBrandList(queryIn, id, name);
        return responseVo;
    }
}
