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
    @RequestMapping("admin/category/l1")
    public ResponseVo categoryLevelOneList(){
        ResponseVo responseVo = categoryService.categoryLableOneList();
        return responseVo;
    }
    //查询二级类目
    @RequestMapping("admin/category/list")
    public ResponseVo categoryList(){
        ResponseVo responseVo = categoryService.categoryList();
        return responseVo;
    }

    //增加类目
    @RequestMapping("admin/category/create")
    public ResponseVo categoryCreate(@RequestBody Category category){
        ResponseVo responseVo = categoryService.categoryCreate(category);
        return responseVo;
    }

    //修改条目
    @RequestMapping("admin/category/update")
    public ResponseVo categoryUpdate(@RequestBody Category category){
        ResponseVo responseVo = categoryService.categoryUpdate(category);
        return responseVo;
    }

    //删除
    @RequestMapping("admin/category/delete")
    public ResponseVo categoryDelete(@RequestBody Category category){
        ResponseVo responseVo = categoryService.categoryDelete(category);
        return responseVo;
    }

    //查询前台首页
    @RequestMapping("wx/catalog/index")
    public ResponseVo findAllCategory(){
        ResponseVo responseVo = categoryService.findAllCategory();
        return responseVo;
    }
    //查询前台一级类目及其二级类目
    @RequestMapping("wx/catalog/current")
    public ResponseVo findCategory(String id){
        ResponseVo responseVo = categoryService.findCategory(id);
        return responseVo;
    }
}
