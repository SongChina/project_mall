package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Coupon;
import com.cskaoyan.mallSpringboot.bean.CouponExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface CouponMapper {
    long countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int deleteByPrimaryKey(Integer id);




    List<Coupon> selectByExample(CouponExample example);

    Coupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByPrimaryKeySelective(Coupon record);


    int insert(Coupon record);
    int insertSelective(Coupon record);//增
    Integer lastInsertId();
    int updateByPrimaryKey(Coupon coupon);//改
    int deleteBydeleted(@Param("id") Integer id, @Param("updateTime") Date updateTime);//删
    int queryCount(@Param("name") String name, @Param("type") String type, @Param("status") String status);//查
    List<Coupon> queryList(@Param("name") String name, @Param("type") String type, @Param("status") String status, @Param("sort") String sort, @Param("order") String order);


}