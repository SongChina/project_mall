package com.cskaoyan.mallSpringboot.service.goods.impl;

import com.cskaoyan.mallSpringboot.bean.*;
import com.cskaoyan.mallSpringboot.mapper.*;
import com.cskaoyan.mallSpringboot.service.goods.GoodsListService;
import com.cskaoyan.mallSpringboot.vo.BaseResultVo;
import com.cskaoyan.mallSpringboot.vo.RequestVo;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

    //统计所有商品数量
    @Override
    public ResponseVo CountGoods() {
        GoodsExample goodsExample = new GoodsExample();
        int total = (int)goodsMapper.countByExample(goodsExample);
        HashMap<String, Object> map = new HashMap<>();
        map.put("goodsCount", total);
        return new ResponseVo(0, map, "成功");
    }

    //获取微信首页所有信息

    @Autowired
    AdMapper adMapper;

    @Autowired
    GrouponrulesMapper grouponrulesMapper;

    @Autowired
    TopicMapper topicMapper;

    @Override
    public ResponseVo getHomeIndexMessage() {
        HashMap<String, Object> map = new HashMap<>();
        //获取首页流动图
        List<Ad> adList = adMapper.queryAllAd();

        //获取首页分类
        List<Category> categoryList = categoryMapper.selectIndexCategoryByPid(0);

        //获取团购规则中的商品
        List<Grouponrules> grouponrulesList = grouponrulesMapper.selectAllGrouponRules();
        //创建团购list
        List<GrouponIndex> grouponIndexList = new ArrayList<>();
        for (Grouponrules grouponrules : grouponrulesList) {
            //获取商品表中的团购商品
            Goods goods = goodsMapper.selectIndexGoods(String.valueOf(grouponrules.getGoodsId()));
            //创建团购对象
            GrouponIndex grouponIndex = new GrouponIndex();
            //封装团购商品
            grouponIndex.setGoods(goods);
            //封装团购数量
            grouponIndex.setGroupon_member(grouponrules.getDiscountMember());
            //封装团购价格（此价格是商品零售价减去团购折扣）
            grouponIndex.setGroupon_price(goods.getRetailPrice().subtract(grouponrules.getDiscount()));
            //添加进团购list
            grouponIndexList.add(grouponIndex);
        }

        //获取品牌商
        List<Brand> brandList = brandMapper.queryIndexBrand();

        //获取新商品
        List<Goods> newGoodsList = goodsMapper.queryIndexNewOrHotGoods(1, 0, null);

        //获取热门商品
        List<Goods> hotGoodsList = goodsMapper.queryIndexNewOrHotGoods(0,1, null);

        //获取精选商品
        List<Topic> topicList = topicMapper.queryIndexTopic();

        //获取底部产品
        List<Category> categories = categoryMapper.queryIndexFloorCategory();
        List floorGoodsList = new ArrayList();
        for (Category category : categories) {
            String categoryId = category.getId().toString().substring(0, 4);
            List<Goods> goodsList = goodsMapper.queryIndexNewOrHotGoods(0, 0, categoryId);
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("goodsList", goodsList);
            map1.put("id", category.getId());
            map1.put("name", category.getName());
            floorGoodsList.add(map1);
        }
        map.put("floorGoodsList", floorGoodsList);

        map.put("topicList", topicList);
        map.put("hotGoodsList", hotGoodsList);
        map.put("newGoodsList", newGoodsList);
        map.put("brandList", brandList);
        map.put("banner", adList);
        map.put("channel", categoryList);
        map.put("grouponList", grouponIndexList);
        return new ResponseVo(0, map, "成功");

    }

    //获取商品分类
    @Override
    public ResponseVo findGoodsCategory(String id) {
        Category category = categoryMapper.selectCategoryById(Integer.parseInt(id));
        HashMap<String, Object> map = new HashMap<>();
        if(category.getPid() == 0){
            List<Category> brotherCategory = categoryMapper.selectCategoryByPid(Integer.parseInt(id));
            Category currentCategory = brotherCategory.get(0);
            map.put("parentCategory", category);
            map.put("brotherCategory", brotherCategory);
            map.put("currentCategory", currentCategory);
        }else {
            Category parentCategory = categoryMapper.selectCategoryById(category.getPid());
            List<Category> brotherCategory = categoryMapper.selectCategoryByPid(parentCategory.getId());
            map.put("parentCategory", parentCategory);
            map.put("brotherCategory", brotherCategory);
            map.put("currentCategory", category);
        }
        return new ResponseVo(0, map, "成功");
    }


    //微信前台获取商品分类
    @Override
    public ResponseVo getGoodsList(String categoryId, String page, String size) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(size));
        List<Category> categoryList = categoryMapper.queryFilterCategoryList();
        List<Goods> goodsList = goodsMapper.queryGoodsByCategoryId(categoryId);
        HashMap<String, Object> map = new HashMap<>();
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        map.put("count", pageInfo.getTotal());
        map.put("filterCategoryList", categoryList);
        map.put("goodsList", pageInfo.getList());
        return new ResponseVo(0, map, "成功");
    }

    //查询前台商品详情
    @Override
    public ResponseVo getWxGoodsDetail(int id) {
        return null;
    }


}
