package com.cskaoyan.mallSpringboot.service.mall.impl;

import com.cskaoyan.mallSpringboot.bean.Category;
import com.cskaoyan.mallSpringboot.mapper.CategoryMapper;
import com.cskaoyan.mallSpringboot.service.mall.CategoryService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    //查询一级类目
    @Override
    public ResponseVo categoryLableOneList() {
       List<Map> mapList = new ArrayList<>();
        int pid = 0;
        List<Category> l1 = categoryMapper.selectCategory(pid);
        for (Category category : l1) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("value", category.getId());
            map.put("lable", category.getName());
            mapList.add(map);
        }
        return new ResponseVo(0, mapList, "成功");
    }


    @Override
    public ResponseVo categoryList() {
        int pid = 0;
        List<Category> l1 = categoryMapper.selectCategory(pid);
        for (Category category : l1) {
            int id = category.getId();
            List<Category> categoryList = categoryMapper.selectCategory(id);
            category.setChildren(categoryList);
        }
        return new ResponseVo(0, l1, "成功");
    }

    //删除
    @Override
    public ResponseVo categoryDelete(Category category) {
        ResponseVo responseVo = new ResponseVo();
        Date date = new Date();
        category.setUpdateTime(date);
        int delete = categoryMapper.categoryDelete(category);
        if(delete == 1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }

}
