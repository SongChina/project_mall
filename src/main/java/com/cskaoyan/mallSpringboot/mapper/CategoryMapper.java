package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Category;
import com.cskaoyan.mallSpringboot.bean.CategoryData;
import com.cskaoyan.mallSpringboot.bean.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    //by wpm
    List<Category> selectCategory(int pid);

    int categoryDelete(Category category);
    //

    //商品管理
    List<CategoryData> categoryList();

    int categoryInsert(Category category);

    Category selectCategoryById(Integer id);

    int categoryUpdate(Category category);
}