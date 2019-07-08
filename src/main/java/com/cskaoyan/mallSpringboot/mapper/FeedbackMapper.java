package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Feedback;
import com.cskaoyan.mallSpringboot.bean.FeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedbackMapper {

    int queryFeedBackCount(@Param("id") String id, @Param("username") String username);
    List<Feedback> queryFeedBackList(@Param("id") String id, @Param("username") String username);

    //以上是新增的
    long countByExample(FeedbackExample example);

    int deleteByExample(FeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    List<Feedback> selectByExample(FeedbackExample example);

    Feedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);


}