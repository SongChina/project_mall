package com.cskaoyan.mallSpringboot.controller.promotion;

import com.cskaoyan.mallSpringboot.bean.Goods;
import com.cskaoyan.mallSpringboot.bean.Groupon;
import com.cskaoyan.mallSpringboot.bean.Grouponrules;
import com.cskaoyan.mallSpringboot.mapper.GoodsMapper;
import com.cskaoyan.mallSpringboot.mapper.GrouponMapper;
import com.cskaoyan.mallSpringboot.mapper.GrouponrulesMapper;
import com.cskaoyan.mallSpringboot.service.promotion.GrouponService;
import com.cskaoyan.mallSpringboot.service.promotion.GrouponrulesService;
import com.cskaoyan.mallSpringboot.util.BaseRespVo;
import com.cskaoyan.mallSpringboot.util.UserTokenManager;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.cskaoyan.mallSpringboot.vo.promotion.ErrorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController

public class GrouponrulesController {
    @Autowired
    GrouponrulesService grouponrulesService;
    @Autowired
    GrouponrulesMapper grouponrulesMapper;
    @Autowired
    GrouponService grouponService;
    @Autowired
    GrouponMapper grouponMapper;
    @Autowired
    GoodsMapper goodsMapper;


    @RequestMapping("admin/groupon/list")
    public ResponseVo grouponrulesPage(QueryIn queryIn, String goodsId) {
        ResponseVo responseVo = grouponrulesService.queryGrouponrulesList(queryIn, goodsId);
        return responseVo;
    }

    @RequestMapping("admin/groupon/create")
    public Object createGrouponrule(@RequestBody Grouponrules grouponrules) {
        ResponseVo responseVo = new ResponseVo();
        try {
            Grouponrules data = grouponrulesService.createGrouponrule(grouponrules);
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(data);
            return responseVo;
        } catch (Exception e) {
            e.printStackTrace();
            ErrorVo errorVo = new ErrorVo();
            errorVo.setErrno(401);
            errorVo.setErrmsg("参数不对");
            return errorVo;
        }
    }

    @RequestMapping("admin/groupon/update")
    public ErrorVo update(@RequestBody Grouponrules grouponrules) {
        grouponrules.setUpdateTime(new Date());
        try {
            grouponrulesService.update(grouponrules);
            return new ErrorVo(0, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401, "参数不对");
        }
    }

    //删
    @RequestMapping("admin/groupon/delete")
    public ErrorVo delete(@RequestBody Grouponrules grouponrules) {
        Integer id = grouponrules.getId();
        Date updateTime = grouponrules.getUpdateTime();
        try {
            grouponrulesService.delete(id, updateTime);
            return new ErrorVo(0, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401, "删除失败，稍后重试");
        }
    }

    @RequestMapping("admin/groupon/listRecord")
    public ResponseVo grouponActivityPage(QueryIn queryIn, String goodsId) {
        HashMap<String, Object> data = new HashMap<>();
        List<Groupon> grouponList = grouponService.queryList(queryIn, goodsId);

        List<Map<String, Object>> groupons = new ArrayList<>();
        for (Groupon groupon : grouponList) {

            Map<String, Object> recordData = new HashMap<>();
            Groupon subGroupon = grouponMapper.selectByPrimaryKey(groupon.getId());
            List<Groupon> subGrouponList = new ArrayList<>();
            subGrouponList.add(subGroupon);
            Grouponrules rules = grouponrulesMapper.selectByPrimaryKey(groupon.getRulesId());
            Goods goods = goodsMapper.selectByPrimaryKey(rules.getGoodsId());

            recordData.put("groupon", groupon);
            recordData.put("subGroupons", subGrouponList);
            recordData.put("rules", rules);
            recordData.put("goods", goods);

            groupons.add(recordData);
        }

        int total = grouponMapper.queryCount(goodsId);
        data.put("total", total);
        data.put("items", groupons);
        //

        return new ResponseVo(0, data, "成功");
    }


    //微信端-我的拼团
    @RequestMapping("wx/groupon/my")
    public Object myGroupon(HttpServletRequest request, Integer showType) {
        //前端写了一个token放在请求头中
        //*************************
        //获得请求头
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        if (userId == null) {
            return BaseRespVo.fail();
        }

        ResponseVo responseVo = grouponrulesService.getMyGroupon(userId, showType);

        return responseVo;
    }
}
