package com.cskaoyan.mallSpringboot.controller.promotion;

import com.cskaoyan.mallSpringboot.service.promotion.GrouponrulesService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("groupon")
public class GrouponController {
    @Autowired
    GrouponrulesService grouponrulesService;
    @RequestMapping("list")
    public ResponseVo grouponrulesPage(QueryIn queryIn, String goodsId){
        ResponseVo responseVo = grouponrulesService.queryGrouponrulesList(queryIn,goodsId);
        return responseVo;
    }
   /* @RequestMapping("create")
    public ResponseVo grouponrulesPage(QueryIn queryIn, String goodsid){
        ResponseVo responseVo = grouponrulesService.queryGrouponrulesList(queryIn,goodsid);
        return responseVo;
    }*/
}
