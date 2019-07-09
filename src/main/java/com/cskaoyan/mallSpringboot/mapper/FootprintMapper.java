package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Footprint;
import com.cskaoyan.mallSpringboot.bean.FootprintData;
import com.cskaoyan.mallSpringboot.bean.FootprintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface FootprintMapper {

    int queryFootPrintCount(@Param("userId") String userId, @Param("goodsId") String goodsId);
    List<Footprint> queryFootPrintList(@Param("userId") String userId, @Param("goodsId") String goodsId);

//    以上是新增的
    long countByExample(FootprintExample example);

    int deleteByExample(FootprintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    List<Footprint> selectByExample(FootprintExample example);

    Footprint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByExample(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);

    //个人中心/我的足迹

    List<FootprintData> footprintList();


}