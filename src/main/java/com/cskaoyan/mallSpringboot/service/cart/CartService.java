package com.cskaoyan.mallSpringboot.service.cart;

import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface CartService {
    ResponseVo addToCart(int userId, Integer goodsId, Integer number, Integer productId);

    ResponseVo getCount(Integer userId);
}
