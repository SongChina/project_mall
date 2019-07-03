package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Userformid;
import com.cskaoyan.mallSpringboot.bean.UserformidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserformidMapper {
    long countByExample(UserformidExample example);

    int deleteByExample(UserformidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userformid record);

    int insertSelective(Userformid record);

    List<Userformid> selectByExample(UserformidExample example);

    Userformid selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userformid record, @Param("example") UserformidExample example);

    int updateByExample(@Param("record") Userformid record, @Param("example") UserformidExample example);

    int updateByPrimaryKeySelective(Userformid record);

    int updateByPrimaryKey(Userformid record);
}