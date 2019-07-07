package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Brand;
import com.cskaoyan.mallSpringboot.bean.BrandData;
import com.cskaoyan.mallSpringboot.bean.BrandExample;
import java.util.List;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {

    int queryBrandCount(@Param("id") String id, @Param("name") String name);
    List<Brand> queryBrandList(@Param("id") String id, @Param("name")  String name);

//    以上是新增的方法
    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);


    //商品管理
    List<BrandData> brandList();




    int brandInsert(Brand brand);

    int brandDelete(Brand brand);



    Brand selectBrandById(Integer id);

    int brandUpdate(Brand brand);
}