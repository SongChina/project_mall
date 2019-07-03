package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Couponuser;
import com.cskaoyan.mallSpringboot.bean.CouponuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponuserMapper {
    long countByExample(CouponuserExample example);

    int deleteByExample(CouponuserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Couponuser record);

    int insertSelective(Couponuser record);

    List<Couponuser> selectByExample(CouponuserExample example);

    Couponuser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Couponuser record, @Param("example") CouponuserExample example);

    int updateByExample(@Param("record") Couponuser record, @Param("example") CouponuserExample example);

    int updateByPrimaryKeySelective(Couponuser record);

    int updateByPrimaryKey(Couponuser record);
}