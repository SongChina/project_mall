package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.User;
import com.cskaoyan.mallSpringboot.bean.UserExample;
import java.util.List;

import com.cskaoyan.mallSpringboot.gss_vo.CustomerStatisticInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface UserMapper {
    //查询数量
    int queryUserCount(@Param("username") String username, @Param("mobile") String mobile);
    //查询列表
    List<User> queryUserList(@Param("username") String username, @Param("mobile") String mobile);

    //以上是新增的方法
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<CustomerStatisticInfo> queryUserByAddTimeInGroup();



}