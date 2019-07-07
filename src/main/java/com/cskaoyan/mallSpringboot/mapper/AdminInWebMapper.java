package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.AdminInWeb;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminInWebMapper {

    int insertAdmin(AdminInWeb adminInWeb);
}
