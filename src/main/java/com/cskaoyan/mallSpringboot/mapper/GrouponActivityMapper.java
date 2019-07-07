package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.GrouponActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrouponActivityMapper {
    int queryCount(@Param("goodsId") String goodsId);
    List<GrouponActivity> queryList(@Param("sort") String sort, @Param("order") String order, @Param("goodsId") String goodsId);
}
