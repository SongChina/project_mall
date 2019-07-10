package com.cskaoyan.mallSpringboot.service.cart.impl;

import com.cskaoyan.mallSpringboot.bean.Cart;
import com.cskaoyan.mallSpringboot.bean.Goods;
import com.cskaoyan.mallSpringboot.bean.Goodsproduct;
import com.cskaoyan.mallSpringboot.mapper.CartMapper;
import com.cskaoyan.mallSpringboot.mapper.GoodsMapper;
import com.cskaoyan.mallSpringboot.mapper.GoodsproductMapper;
import com.cskaoyan.mallSpringboot.mapper.UserMapper;
import com.cskaoyan.mallSpringboot.service.cart.CartService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsproductMapper goodsproductMapper;

    @Override
    public ResponseVo addToCart(int userId, Integer goodsId, Integer number, Integer productId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        Cart cart = new Cart();
        cart.setGoodsSn(goods.getGoodsSn());
        cart.setGoodsName(goods.getName());
        Goodsproduct goodsproduct = goodsproductMapper.selectByPrimaryKey(productId);
        cart.setPrice(goodsproduct.getPrice());
        cart.setNumber(number);
        cart.setSpecifications(goodsproduct.getSpecifications());
        cart.setChecked(false);
        cart.setPicUrl(goodsproduct.getUrl());
        int insert = cartMapper.insertCart(cart);
        ResponseVo responseVo = new ResponseVo();
        if(insert == 1){
            responseVo.setErrno(0);
            responseVo.setData(number);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(510);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }

    @Override
    public ResponseVo getCount(Integer userId) {
        List<Cart> cartList = cartMapper.queryCartCountByUserId(userId);
        int count = 0;
        for (Cart cart : cartList) {
            count += cart.getNumber();
        }
        return new ResponseVo(0, count, "成功");
    }
}
