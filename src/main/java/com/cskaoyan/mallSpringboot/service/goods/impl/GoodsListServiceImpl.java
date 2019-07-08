package com.cskaoyan.mallSpringboot.service.goods.impl;

import com.cskaoyan.mallSpringboot.bean.*;
import com.cskaoyan.mallSpringboot.mapper.*;
import com.cskaoyan.mallSpringboot.service.goods.GoodsListService;
import com.cskaoyan.mallSpringboot.vo.BaseResultVo;
import com.cskaoyan.mallSpringboot.vo.RequestVo;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoodsListServiceImpl implements GoodsListService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    GoodsattributeMapper goodsattributeMapper;
    @Autowired
    GoodsproductMapper goodsproductMapper;
    @Autowired
    GoodsspecificationMapper goodsspecificationMapper;
    @Autowired
    GoodsInWebMapper goodsInWebMapper;
    @Autowired
    ProductsInWebMapper productsInWebMapper;
    @Autowired
    AttributeInWebMapper attributeInWebMapper;
    @Autowired
    SpecificationInWebMapper specificationInWebMapper;



    @Override
    public ResponseVo getALLGoodsList(RequestVo requestVo, Integer goodsSn, String name) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if (goodsSn != null && goodsSn != 0){
            criteria.andGoodsSnEqualTo(goodsSn);
        }else if (name != null && name!= ""){
            criteria.andNameLike("%"+name+"%");
        }else {
            criteria.getAllCriteria();
        }
        PageHelper.startPage(requestVo.getPage(),requestVo.getLimit());
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        BaseResultVo<Goods> baseResultVo = new BaseResultVo<>();
        baseResultVo.setItems(goodsList);
        int total = (int) goodsMapper.countByExample(goodsExample);
        baseResultVo.setTotal(total);
        return new ResponseVo(0,baseResultVo,"成功");
    }

    @Override
    public ResponseVo getGoodsDetail(int id) {
        GoodsattributeExample goodsattributeExample = new GoodsattributeExample();
        GoodsattributeExample.Criteria criteria = goodsattributeExample.createCriteria().andGoodsIdEqualTo(id);
        List<Goodsattribute> attributes = goodsattributeMapper.selectByExample(goodsattributeExample);

        Integer[] categoryIds = goodsMapper.selectCategoryIdById(id);

        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria1 = goodsExample.createCriteria().andIdEqualTo(id);
        Goods goods =(Goods) goodsMapper.selectByExample(goodsExample);

        GoodsproductExample goodsproductExample = new GoodsproductExample();
        GoodsproductExample.Criteria criteria2 = goodsproductExample.createCriteria().andGoodsIdEqualTo(id);
        List<Goodsproduct> products = goodsproductMapper.selectByExample(goodsproductExample);

        GoodsspecificationExample goodsspecificationExample = new GoodsspecificationExample();
        GoodsspecificationExample.Criteria criteria3 = goodsspecificationExample.createCriteria().andGoodsIdEqualTo(id);
        List<Goodsspecification> specifications = goodsspecificationMapper.selectByExample(goodsspecificationExample);

        GoodsDetailData goodsDetailData = new GoodsDetailData();
        goodsDetailData.setAttributes(attributes);
        goodsDetailData.setCategoryIds(categoryIds);
        goodsDetailData.setGoods(goods);
        goodsDetailData.setProducts(products);
        goodsDetailData.setSpecifications(specifications);

        return new ResponseVo(0,goodsDetailData,"成功");
    }

    @Override
    public ResponseVo catAndBrand() {
        List<BrandData> brandList = brandMapper.brandList();
        List<CategoryData> categoryList = categoryMapper.categoryList();
        CatAndbBrandData catAndbBrandData = new CatAndbBrandData();
        catAndbBrandData.setBrandList(brandList);
        catAndbBrandData.setCategoryList(categoryList);
        return new ResponseVo(0,catAndbBrandData,"成功");
    }

    @Override
    public ResponseVo deletById(Goods goods) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria().andIdEqualTo(goods.getId());
        int i = goodsMapper.deleteByExample(goodsExample);
        return new ResponseVo(0,"","成功");
    }

    @Override
    public ResponseVo insertGoods(GoodsInsertData goodsInsertData) {
      String goodsSn = goodsInsertData.getGoods().getGoodsSn();
        int goodsId = Integer.valueOf(goodsSn).intValue();
        List<AttributeInWeb> attributes = goodsInsertData.getAttributes();
        for (AttributeInWeb attributeInWeb:attributes) {
            attributeInWeb.setGoodsId(goodsId);
            attributeInWebMapper.insert(attributeInWeb);
        }

        GoodsInWeb goods = goodsInsertData.getGoods();
        goodsInWebMapper.insert(goods);

        List<ProductsInWeb> products = goodsInsertData.getProducts();
        for (ProductsInWeb productsInWeb:products) {
            productsInWeb.setGoodsId(goodsId);
            productsInWebMapper.insert(productsInWeb);
        }

        List<SpecificationsInWeb> specifications = goodsInsertData.getSpecifications();
        for (SpecificationsInWeb specificationsInWeb:specifications) {
            specificationsInWeb.setGoodsId(goodsId);
            specificationInWebMapper.insert(specificationsInWeb);
        }
        return new ResponseVo(0,"","成功");



    }

    /*@Override
    public ResponseVo storageCreate(File file) {
        return null;
    }*/


}
