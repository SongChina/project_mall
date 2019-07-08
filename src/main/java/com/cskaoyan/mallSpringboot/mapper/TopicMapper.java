package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Topic;
import com.cskaoyan.mallSpringboot.bean.TopicExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TopicMapper {
    long countByExample(TopicExample example);

    int deleteByExample(TopicExample example);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Topic record);

    List<Topic> selectByExampleWithBLOBs(TopicExample example);

    List<Topic> selectByExample(TopicExample example);

    Topic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByExampleWithBLOBs(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByExample(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);
    int insert(Topic record);//增
    Integer lastInsertId();
    int updateByPrimaryKey(Topic record);//改
    int deleteBydeleted(@Param("id") Integer id, @Param("updateTime") Date updateTime);//删
    int queryCount(@Param("title") String title, @Param("subtitle") String subtitle);//查
    List<Topic> queryList(@Param("title") String title, @Param("subtitle")  String subtitle,@Param("sort") String sort,@Param("order") String order);
}