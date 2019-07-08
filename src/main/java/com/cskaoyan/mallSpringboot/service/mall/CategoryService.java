package com.cskaoyan.mallSpringboot.service.mall;

import com.cskaoyan.mallSpringboot.bean.Category;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface CategoryService {
    ResponseVo categoryList();

    ResponseVo categoryLableOneList();

    ResponseVo categoryDelete(Category category);

    ResponseVo categoryCreate(Category category);

    ResponseVo categoryUpdate(Category category);

    ResponseVo findAllCategory();

    ResponseVo findCategory(String id);
}
