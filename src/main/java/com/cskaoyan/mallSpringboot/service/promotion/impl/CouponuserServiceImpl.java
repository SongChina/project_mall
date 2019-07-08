package com.cskaoyan.mallSpringboot.service.promotion.impl;

import com.cskaoyan.mallSpringboot.bean.Couponuser;
import com.cskaoyan.mallSpringboot.mapper.CouponuserMapper;
import com.cskaoyan.mallSpringboot.service.promotion.CouponuserService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CouponuserServiceImpl implements CouponuserService {
    @Autowired
    CouponuserMapper couponuserMapper;



    @Override
    public ResponseVo queryList(QueryIn queryIn, String couponId, String userId, String status) {
        HashMap<String, Object> data = new HashMap<>();

        int total = couponuserMapper.queryCount(couponId,userId,status);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Couponuser> list = couponuserMapper.selectByCouponId(couponId,userId,status, queryIn.getSort(), queryIn.getOrder());
        PageInfo<Couponuser> pageInfo = new PageInfo<>(list);
        data.put("total",total);
        data.put("items",pageInfo.getList());

        return new ResponseVo(0,data,"成功");
    }
}
