package com.cskaoyan.mallSpringboot.controller.mall;

import com.cskaoyan.mallSpringboot.bean.Category;
import com.cskaoyan.mallSpringboot.service.mall.CategoryService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //查询一级类目
    @RequestMapping("category/l1")
    public ResponseVo categoryLevelOneList(){
        ResponseVo responseVo = categoryService.categoryLableOneList();
        return responseVo;
    }
    //查询二级类目
    @RequestMapping("category/list")
    public ResponseVo categoryList(){
        ResponseVo responseVo = categoryService.categoryList();
        return responseVo;
    }

    //删除
    @RequestMapping("category/delete")
    public ResponseVo categoryDelete(@RequestBody Category category){
        ResponseVo responseVo = categoryService.categoryDelete(category);
        return responseVo;
    }

}
