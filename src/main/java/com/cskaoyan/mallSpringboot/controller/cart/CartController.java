package com.cskaoyan.mallSpringboot.controller.cart;

import com.cskaoyan.mallSpringboot.service.cart.CartService;
import com.cskaoyan.mallSpringboot.util.JacksonUtil;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("wx/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping("add")
    public ResponseVo addCart(@RequestBody String jackonGoodsId, String jackonNumber,  String jackonProductId){
        int userId = 1;
        Integer goodsId = JacksonUtil.parseInteger(jackonGoodsId, "goodsId");
        Integer number = JacksonUtil.parseInteger(jackonNumber, "number");
        Integer productId = JacksonUtil.parseInteger(jackonProductId, "productId");
        ResponseVo responseVo = cartService.addToCart(userId, goodsId, number, productId);
        return responseVo;
    }

    //查询总数
    @RequestMapping("goodscount")
    public ResponseVo getCartCount(){
        int userId = 1;
        ResponseVo responseVo = cartService.getCount(userId);
      return responseVo;
    }

    @RequestMapping("index")
    public ResponseVo getCartIndex(){
        int userId = 1;
        ResponseVo responseVo = cartService.getCount(userId);
      return responseVo;
    }
}
