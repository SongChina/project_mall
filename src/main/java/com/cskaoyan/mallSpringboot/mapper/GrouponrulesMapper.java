package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Grouponrules;
import com.cskaoyan.mallSpringboot.bean.GrouponrulesExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface GrouponrulesMapper {
    long countByExample(GrouponrulesExample example);

    int deleteByExample(GrouponrulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Grouponrules record);//增
    Integer lastInsertId();

    int insertSelective(Grouponrules record);

    List<Grouponrules> selectByExample(GrouponrulesExample example);

    Grouponrules selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Grouponrules record, @Param("example") GrouponrulesExample example);

    int updateByExample(@Param("record") Grouponrules record, @Param("example") GrouponrulesExample example);

    int updateByPrimaryKeySelective(Grouponrules record);

    int updateByPrimaryKey(Grouponrules record);//改
    int deleteBydeleted(@Param("id") Integer id, @Param("updateTime") Date updateTime);//删
    //查
    int queryCount(@Param("goodsId") String goodsId);
    List<Grouponrules> queryList(@Param("sort") String sort,@Param("order") String order,@Param("goodsId") String goodsId);

    List<Grouponrules> selectAllGrouponRules();

}