package com.cskaoyan.mallSpringboot.service.personalcenter.impl;

import com.cskaoyan.mallSpringboot.bean.Coupon;
import com.cskaoyan.mallSpringboot.bean.CouponData;
import com.cskaoyan.mallSpringboot.bean.CouponExample;
import com.cskaoyan.mallSpringboot.mapper.CouponMapper;
import com.cskaoyan.mallSpringboot.service.personalcenter.CouponDataService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponDataServieImpl implements CouponDataService {
    @Autowired
    CouponMapper couponMapper;
    @Override
    public ResponseVo couponList(int status, int page, int size) {
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        if (status == 0){

            criteria.getAllCriteria();
        }else if (status == 1){

            criteria.andStatusEqualTo((short) 1);
        }
        int count = (int) couponMapper.countByExample(couponExample);
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        CouponData couponData = new CouponData();
        couponData.setCount(count);
        couponData.setData(coupons);
        return new ResponseVo(0,couponData,"成功");
    }

}
