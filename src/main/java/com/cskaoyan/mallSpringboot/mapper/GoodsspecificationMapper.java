package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Goodsspecification;
import com.cskaoyan.mallSpringboot.bean.GoodsspecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface GoodsspecificationMapper {
    long countByExample(GoodsspecificationExample example);

    int deleteByExample(GoodsspecificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goodsspecification record);

    int insertSelective(Goodsspecification record);

    List<Goodsspecification> selectByExample(GoodsspecificationExample example);

    Goodsspecification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goodsspecification record, @Param("example") GoodsspecificationExample example);

    int updateByExample(@Param("record") Goodsspecification record, @Param("example") GoodsspecificationExample example);

    int updateByPrimaryKeySelective(Goodsspecification record);

    int updateByPrimaryKey(Goodsspecification record);

    List<Goodsspecification> queryGoodsspecificationByGoodId(Integer id);
}