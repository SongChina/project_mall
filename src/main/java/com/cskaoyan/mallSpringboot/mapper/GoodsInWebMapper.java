package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.GoodsInWeb;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface GoodsInWebMapper {
    int insert(@Param("goods")GoodsInWeb goodsInWeb);
}
