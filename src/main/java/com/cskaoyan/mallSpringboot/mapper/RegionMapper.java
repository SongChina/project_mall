package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Region;
import com.cskaoyan.mallSpringboot.bean.RegionExample;
import java.util.List;

import com.cskaoyan.mallSpringboot.bean.User;
import org.apache.ibatis.annotations.Param;

public interface RegionMapper {



    long countByExample(RegionExample example);

    int deleteByExample(RegionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Region record);

    int insertSelective(Region record);

    List<Region> selectByExample(RegionExample example);

    Region selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByExample(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);


    List<Region> queryProvince();

    List<Region> queryCity(String code);

    List<Region> queryDistrict(String code);

    List<Region> queryByPid(@Param("pid") String pid);
}