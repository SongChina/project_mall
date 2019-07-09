package com.cskaoyan.mallSpringboot.controller.mall;

import com.cskaoyan.mallSpringboot.bean.Brand;
import com.cskaoyan.mallSpringboot.service.mall.BrandService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BrandController {

    @Autowired
    BrandService brandService;

    //查找
    @RequestMapping("admin/brand/list")
    public ResponseVo brand(QueryIn queryIn, String id, String name){
        ResponseVo responseVo = brandService.queryBrandList(queryIn, id, name);
        return responseVo;
    }
    //新增
    @RequestMapping("admin/brand/create")
    public ResponseVo brandCreate(@RequestBody Brand brand){
        ResponseVo responseVo = brandService.brandCreate(brand);
        return responseVo;
    }
    //修改
    @RequestMapping("admin/brand/update")
    public ResponseVo brandUpdate(@RequestBody Brand brand){
        ResponseVo responseVo = brandService.brandUpdate(brand);
        return responseVo;
    }
    //删除
    @RequestMapping("admin/brand/delete")
    public Map brandDelete(@RequestBody Brand brand){
        return brandService.brandDelete(brand);
    }


    //以下属于微信前端内容
    //品牌详情
    @RequestMapping("wx/brand/detail")
    public ResponseVo brandDetail(String id){
        return brandService.brandDetail(id);
    }
}
