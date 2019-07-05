package com.cskaoyan.mallSpringboot.service.mall.impl;

import com.cskaoyan.mallSpringboot.bean.Brand;
import com.cskaoyan.mallSpringboot.mapper.BrandMapper;
import com.cskaoyan.mallSpringboot.service.mall.BrandService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    //查询
    @Override
    public ResponseVo queryBrandList(QueryIn queryIn, String id, String name) {
        HashMap<String, Object> map = new HashMap<>();
        if(id!=null){
            id = "%" + id + "%";
        }
        if(name != null){
            name = "%" + name + "%";
        }
        int total = brandMapper.queryBrandCount(id, name);

        map.put("total", total);
        /*if(total % queryIn.getLimit() ==0){
            map.put("pages", total/queryIn.getLimit());
        }else {
            map.put("pages", total/queryIn.getLimit() + 1);
        }
        map.put("page", queryIn.getPage());
        map.put("limit", queryIn.getLimit());*/
        PageHelper.startPage(queryIn.getPage(), queryIn.getLimit());
        List<Brand> brandList = brandMapper.queryBrandList(id, name);
        map.put("items", brandList);
        return new ResponseVo(0, map, "成功");
    }

    //插入
    @Override
    public ResponseVo brandCreate(Brand brand) {
        ResponseVo responseVo = new ResponseVo();
        Date date = new Date();
        brand.setAddTime(date);
        brand.setUpdateTime(date);
        int create = brandMapper.brandInsert(brand);
        if(create == 1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }
    //删除
    @Override
    public ResponseVo brandDelete(Brand brand) {
        ResponseVo responseVo = new ResponseVo();
        int delete = brandMapper.brandDelete(brand);
        if(delete == 1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }

    //修改
    @Override
    public ResponseVo brandUpdate(Brand brand) {
        ResponseVo responseVo = new ResponseVo();
        int update = brandMapper.brandUpdate(brand);
        if(update == 1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }
}
