package com.cskaoyan.mallSpringboot.controller.goods;

import com.cskaoyan.mallSpringboot.bean.Goods;
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

    @RequestMapping("admin/goods/list")
    public ResponseVo getALLGoodsList(RequestVo requestVo, Integer goodsSn, String name) {
        ResponseVo goodsList = goodsListService.getALLGoodsList(requestVo, goodsSn, name);
        return goodsList;
    }

    @RequestMapping("admin/goods/detail")
    public ResponseVo getGoodsDetail(int id){
        return goodsListService.getGoodsDetail(id);
    }

    @RequestMapping("admin/goods/catAndBrand")
    public ResponseVo catAndBrand(){
        return goodsListService.catAndBrand();
    }

    @RequestMapping("admin/goods/delete")
    public ResponseVo delete(@RequestBody Goods goods){
        return goodsListService.deletById(goods);
    }

    @RequestMapping("admin/goods/create")
    public ResponseVo insertGoods(@RequestBody GoodsInsertData goodsInsertData){
        return goodsListService.insertGoods(goodsInsertData);
    }
    @RequestMapping("admin/goods/count")
    public ResponseVo CountGoods(){
        return goodsListService.CountGoods();
    }


    //以下属于微信前台内容
    //微信小程序


    @RequestMapping("wx/goods/count")
    public ResponseVo WXCountGoods(){

        return goodsListService.CountGoods();
    }

    @RequestMapping("wx/goods/category")
    public ResponseVo getGoodsCategory(String id){
        ResponseVo responseVo = goodsListService.findGoodsCategory(id);
        return responseVo;
    }
    //查询商品分类
    @RequestMapping("wx/goods/list")
    public ResponseVo getGoodsList(String categoryId, String page, String size, boolean isNew, boolean isHot, String order, String keyword) {
        ResponseVo goodsList = goodsListService.getGoodsList(categoryId, page, size, isHot, isNew, order, keyword);
        return goodsList;
    }
    //查询前台商品详情
    @RequestMapping("wx/goods/detail")
    public ResponseVo getWxGoodsDetail(int id) {
        ResponseVo responseVo = goodsListService.getWxGoodsDetail(id);
        return responseVo;

    }

    //查询商品评论
    @RequestMapping("wx/comment/list")
    public ResponseVo getGoodsComment(int valueId, String type, String showType, int page, int size) {
        ResponseVo responseVo = goodsListService.getGoodsComment(valueId, type, showType, page, size);
        return responseVo;
    }

}
