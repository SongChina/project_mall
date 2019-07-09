package com.cskaoyan.mallSpringboot.controller.promotion;


import com.cskaoyan.mallSpringboot.bean.Coupon;
import com.cskaoyan.mallSpringboot.mapper.CouponMapper;
import com.cskaoyan.mallSpringboot.service.promotion.CouponService;
import com.cskaoyan.mallSpringboot.service.promotion.CouponuserService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.cskaoyan.mallSpringboot.vo.promotion.ErrorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("coupon")
public class CouponController {
    @Autowired
    CouponService couponService;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    CouponuserService couponuserService;

    @RequestMapping("list")
    public ResponseVo couponList(QueryIn queryIn, String name, String type, String status) {
        return couponService.queryList(queryIn, name, type, status);

    }

    @RequestMapping("create")
    public Object createcoupon(@RequestBody Coupon coupon) {
        try {
            Coupon data = couponService.createCoupon(coupon);
            return new ResponseVo(0, data, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401, "参数不对");
        }
    }

    @RequestMapping("update")
    public Object update(@RequestBody Coupon coupon) {
        coupon.setUpdateTime(new Date());
        coupon.setDeleted(false);
        try {
            couponService.update(coupon);
            return new ResponseVo(0, coupon, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401, "参数不对");
        }
    }

    @RequestMapping("delete")
    public ErrorVo delete(@RequestBody Coupon coupon) {
        Integer id = coupon.getId();
        Date updateTime = coupon.getUpdateTime();
        try {
            couponService.delete(id, updateTime);
            return new ErrorVo(0, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401, "删除失败，稍后重试");
        }
    }

    @RequestMapping("read")
    public ResponseVo read(Integer id) {
        Coupon coupon = couponMapper.selectByPrimaryKey(id);
        return new ResponseVo(0, coupon, "成功");
    }

    @RequestMapping("listuser")
    public ResponseVo listUser(QueryIn queryIn, String couponId, String userId, String status) {

        return couponuserService.queryList(queryIn,couponId,userId,status);
    }
}
