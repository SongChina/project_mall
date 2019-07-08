package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Ad;
import com.cskaoyan.mallSpringboot.bean.AdExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AdMapper {
    long countByExample(AdExample example);

    int deleteByExample(AdExample example);

    int deleteByPrimaryKey(Integer id);



    int insertSelective(Ad record);

    List<Ad> selectByExample(AdExample example);

    Ad selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ad record, @Param("example") AdExample example);

    int updateByExample(@Param("record") Ad record, @Param("example") AdExample example);

    int updateByPrimaryKeySelective(Ad record);

    int insert(Ad record);//增
    Integer lastInsertId();
    int updateByPrimaryKey(Ad record);//改
    int deleteBydeleted(@Param("id") Integer id, @Param("updateTime") Date updateTime);//删
    int queryCount(@Param("name") String name, @Param("content") String content);//查
    List<Ad> queryList(@Param("name") String name, @Param("content")  String content, @Param("sort") String sort, @Param("order") String order);

}