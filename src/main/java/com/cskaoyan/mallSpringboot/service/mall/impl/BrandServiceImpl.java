package com.cskaoyan.mallSpringboot.service.mall.impl;

import com.cskaoyan.mallSpringboot.bean.Brand;
import com.cskaoyan.mallSpringboot.mapper.BrandMapper;
import com.cskaoyan.mallSpringboot.service.mall.BrandService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;

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
}
