package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.ProductsInWeb;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ProductsInWebMapper {
    int insert(@Param("products")ProductsInWeb productsInWeb);
}
