package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Goodsproduct;
import com.cskaoyan.mallSpringboot.bean.GoodsproductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsproductMapper {
    long countByExample(GoodsproductExample example);

    int deleteByExample(GoodsproductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goodsproduct record);

    int insertSelective(Goodsproduct record);

    List<Goodsproduct> selectByExample(GoodsproductExample example);

    Goodsproduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goodsproduct record, @Param("example") GoodsproductExample example);

    int updateByExample(@Param("record") Goodsproduct record, @Param("example") GoodsproductExample example);

    int updateByPrimaryKeySelective(Goodsproduct record);

    int updateByPrimaryKey(Goodsproduct record);
}