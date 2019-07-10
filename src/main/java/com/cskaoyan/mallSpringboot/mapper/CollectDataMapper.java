package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.CollectData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CollectDataMapper {
   List<CollectData> selectByType(@Param("type") int type,@Param("userId") int userId);
}
