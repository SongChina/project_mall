package com.cskaoyan.mallSpringboot.service.promotion.impl;

import com.cskaoyan.mallSpringboot.bean.Coupon;
import com.cskaoyan.mallSpringboot.mapper.CouponMapper;
import com.cskaoyan.mallSpringboot.service.promotion.CouponService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    CouponMapper couponMapper;

    @Override
    public Coupon createCoupon(Coupon coupon) {
        coupon.setAddTime(new Date());
        coupon.setUpdateTime(new Date());
        coupon.setDeleted(false);

        int insert = couponMapper.insert(coupon);
        Integer id = couponMapper.lastInsertId();
        coupon.setId(id);
        return coupon;
    }

    @Override
    public int delete(Integer id, Date updateTime) {
        int i = couponMapper.deleteBydeleted(id, updateTime);
        return i;
    }

    @Override
    public int update(Coupon coupon) {
        int i = couponMapper.updateByPrimaryKey(coupon);
        return i;
    }

    @Override
    public ResponseVo queryList(QueryIn queryIn, String name, String type, String status) {
        HashMap<String, Object> data = new HashMap<>();
        //条件,用于模糊查询
        if (name != null & name != ""){
            name = "%" + name + "%";
        }
        int total = couponMapper.queryCount(name,type,status);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Coupon> list = couponMapper.queryList(name,type,status, queryIn.getSort(), queryIn.getOrder());
        PageInfo<Coupon> pageInfo = new PageInfo<>(list);
        data.put("total",total);
        data.put("items",pageInfo.getList());

        return new ResponseVo(0,data,"成功");
    }
}
