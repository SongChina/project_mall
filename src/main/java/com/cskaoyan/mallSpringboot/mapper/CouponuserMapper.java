package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Couponuser;
import com.cskaoyan.mallSpringboot.bean.CouponuserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    int queryCount(@Param("couponId") String couponId, @Param("userId") String userId, @Param("status") String status);//查
    List<Couponuser> selectByCouponId(@Param("couponId") String couponId, @Param("userId") String userId, @Param("status") String status, @Param("sort") String sort, @Param("order") String order);//
}