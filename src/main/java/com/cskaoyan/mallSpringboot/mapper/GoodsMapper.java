package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Goods;
import com.cskaoyan.mallSpringboot.bean.GoodsExample;
import java.util.List;

import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExampleWithBLOBs(GoodsExample example);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    //商品管理
    Integer[] selectCategoryIdById(int id);


    Goods selectIndexGoods(String goodsSn);

    List<Goods> queryIndexNewOrHotGoods(@Param("isNew") int isNew, @Param("isHot") int isHot, @Param("categoryId") String categoryId);

    List<Goods> queryGoodsByCategoryId(@Param("categoryId") String categoryId, @Param("isNew") boolean isNew , @Param("isHot") boolean isHot, @Param("order") String order, @Param("keyword") String keyword);

    Goods queryGoodsById(@Param("id") int id);

}