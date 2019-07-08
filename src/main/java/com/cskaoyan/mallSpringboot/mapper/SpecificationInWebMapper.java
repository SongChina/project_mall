package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.SpecificationsInWeb;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface SpecificationInWebMapper {
    int insert(@Param("specification") SpecificationsInWeb specificationsInWeb);
}
