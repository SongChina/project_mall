package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.AttributeInWeb;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface AttributeInWebMapper {
    int insert(@Param("attribute") AttributeInWeb attributeInWeb);
}
