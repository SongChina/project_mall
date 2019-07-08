package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Goodsattribute;
import com.cskaoyan.mallSpringboot.bean.GoodsattributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface GoodsattributeMapper {
    long countByExample(GoodsattributeExample example);

    int deleteByExample(GoodsattributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goodsattribute record);

    int insertSelective(Goodsattribute record);

    List<Goodsattribute> selectByExample(GoodsattributeExample example);

    Goodsattribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goodsattribute record, @Param("example") GoodsattributeExample example);

    int updateByExample(@Param("record") Goodsattribute record, @Param("example") GoodsattributeExample example);

    int updateByPrimaryKeySelective(Goodsattribute record);

    int updateByPrimaryKey(Goodsattribute record);






}