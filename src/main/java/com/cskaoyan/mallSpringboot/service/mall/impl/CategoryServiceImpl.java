package com.cskaoyan.mallSpringboot.service.mall.impl;

import com.cskaoyan.mallSpringboot.bean.Brand;
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
        List<Category> l1 = categoryMapper.selectCategoryByPid(pid);
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
        List<Category> l1 = categoryMapper.selectCategoryByPid(pid);
        for (Category category : l1) {
            int id = category.getId();
            List<Category> categoryList = categoryMapper.selectCategoryByPid(id);
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

    //新增
    @Override
    public ResponseVo categoryCreate(Category category) {
        ResponseVo responseVo = new ResponseVo();
        Date date = new Date();
        category.setAddTime(date);
        category.setUpdateTime(date);
        int create = categoryMapper.categoryInsert(category);
        Category category1 = categoryMapper.selectCategoryById(category.getId());
        if(create == 1 && category1 != null){
            responseVo.setErrno(0);
            responseVo.setData(category1);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }

    //修改
    @Override
    public ResponseVo categoryUpdate(Category category) {
        ResponseVo responseVo = new ResponseVo();
        int update = categoryMapper.categoryUpdate(category);
        Category category1 = categoryMapper.selectCategoryById(category.getId());
        if(update == 1 && category1 != null){
            responseVo.setErrno(0);
            responseVo.setData(category1);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(605);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }

    //微信前台查找所有分类详情
    @Override
    public ResponseVo findAllCategory() {
        HashMap<String, Object> map = new HashMap<>();
        Category category = categoryMapper.queryFirstCategory();
        List<Category> categoryListLevel1 = categoryMapper.selectCategoryByPid(0);
        List<Category> categoryListlevel2 = categoryMapper.selectCategoryByPid(category.getId());
        map.put("currentCategory", category);
        map.put("categoryList", categoryListLevel1);
        map.put("currentSubCategory", categoryListlevel2);
        return new ResponseVo(0, map, "成功");
    }

    //微信前台查找一级分类及其子分类
    @Override
    public ResponseVo findCategory(String id) {
        Category category = categoryMapper.selectCategoryById(Integer.parseInt(id));
        List<Category> categoryListlevel2 = categoryMapper.selectCategoryByPid(category.getId());
        HashMap<String, Object> map = new HashMap<>();
        map.put("currentCategory", category);
        map.put("currentSubCategory", categoryListlevel2);
        return new ResponseVo(0, map, "成功");
    }

}
