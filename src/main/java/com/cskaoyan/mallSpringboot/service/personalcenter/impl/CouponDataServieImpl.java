package com.cskaoyan.mallSpringboot.service.personalcenter.impl;

import com.cskaoyan.mallSpringboot.bean.*;
import com.cskaoyan.mallSpringboot.mapper.CouponMapper;
import com.cskaoyan.mallSpringboot.mapper.CouponuserMapper;
import com.cskaoyan.mallSpringboot.service.personalcenter.CouponDataService;
import com.cskaoyan.mallSpringboot.util.UserTokenManager;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CouponDataServieImpl implements CouponDataService {
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    CouponuserMapper couponuserMapper;
    @Override
    public ResponseVo couponList(int status, int page, int size, HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        CouponuserExample couponuserExample = new CouponuserExample();
        CouponuserExample.Criteria criteria1 = couponuserExample.createCriteria();
        CouponuserExample.Criteria criteria2 = criteria1.andUserIdEqualTo(userId);
        List<Couponuser> couponusers = couponuserMapper.selectByExample(couponuserExample);
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        //获取用户每张优惠券的id
        for (Couponuser couponuser:couponusers) {
            Integer couponId = couponuser.getCouponId();
            if (status == 0){
                CouponExample.Criteria criteria3 = criteria.andIdEqualTo(couponId).andStatusEqualTo((short) 0);
            }else if (status == 1){
                CouponExample.Criteria criteria4 = criteria.andIdEqualTo(couponId).andStatusEqualTo((short) 1);
            }

        }

        int count = (int) couponMapper.countByExample(couponExample);
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        CouponData couponData = new CouponData();
        couponData.setCount(count);
        couponData.setData(coupons);
        return new ResponseVo(0,couponData,"成功");
    }

}
