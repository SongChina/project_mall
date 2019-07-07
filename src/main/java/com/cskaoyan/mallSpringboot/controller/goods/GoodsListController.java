package com.cskaoyan.mallSpringboot.controller.goods;

import com.cskaoyan.mallSpringboot.bean.Goods;
import com.cskaoyan.mallSpringboot.bean.GoodsInWeb;
import com.cskaoyan.mallSpringboot.bean.GoodsInsertData;
import com.cskaoyan.mallSpringboot.service.goods.GoodsListService;
import com.cskaoyan.mallSpringboot.vo.RequestVo;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsListController {
    @Autowired
    GoodsListService goodsListService;

    @RequestMapping("goods/list")
    public ResponseVo getALLGoodsList(RequestVo requestVo, Integer goodsSn, String name) {
        ResponseVo goodsList = goodsListService.getALLGoodsList(requestVo, goodsSn, name);
        return goodsList;
    }

    @RequestMapping("goods/detail")
    public ResponseVo getGoodsDetail(int id){
        return goodsListService.getGoodsDetail(id);
    }

    @RequestMapping("goods/catAndBrand")
    public ResponseVo catAndBrand(){
        return goodsListService.catAndBrand();
    }

    @RequestMapping("goods/delete")
    public ResponseVo delete(@RequestBody Goods goods){
        return goodsListService.deletById(goods);
    }

    @RequestMapping("goods/create")
    public ResponseVo insertGoods(@RequestBody GoodsInsertData goodsInsertData){
        return goodsListService.insertGoods(goodsInsertData);
    }

    /*@RequestMapping("storage/create")
    public ResponseVo storageCreate(File file){ return goodsListService.storageCreate(file); }*/
}
