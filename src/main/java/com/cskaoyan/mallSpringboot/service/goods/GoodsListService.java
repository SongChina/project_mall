package com.cskaoyan.mallSpringboot.service.goods;

import com.cskaoyan.mallSpringboot.bean.Goods;
import com.cskaoyan.mallSpringboot.bean.GoodsInsertData;
import com.cskaoyan.mallSpringboot.vo.RequestVo;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestBody;

public interface GoodsListService {
    ResponseVo getALLGoodsList(RequestVo requestVo,Integer goodsSn,String name);

    ResponseVo getGoodsDetail(int id);

    ResponseVo catAndBrand();

    ResponseVo deletById(Goods goods);

    ResponseVo insertGoods(@RequestBody GoodsInsertData goodsInsertData);

    //ResponseVo storageCreate(File file);


    ResponseVo CountGoods();

    ResponseVo getHomeIndexMessage();

    ResponseVo findGoodsCategory(String id);

    ResponseVo getGoodsList(String categoryId, String page, String size, boolean idNew, boolean isHot, String order, String keyword);

    ResponseVo getWxGoodsDetail(int id);

    ResponseVo getGoodsComment(int valueId, String type, String showType, int page, int size);
}
