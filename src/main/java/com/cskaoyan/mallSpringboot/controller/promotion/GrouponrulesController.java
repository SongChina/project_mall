package com.cskaoyan.mallSpringboot.controller.promotion;

import com.cskaoyan.mallSpringboot.bean.Grouponrules;
import com.cskaoyan.mallSpringboot.service.promotion.GrouponActivityService;
import com.cskaoyan.mallSpringboot.service.promotion.GrouponrulesService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.cskaoyan.mallSpringboot.vo.promotion.ErrorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class GrouponrulesController {
    @Autowired
    GrouponrulesService grouponrulesService;
    @Autowired
    GrouponActivityService grouponActivityService;


    @RequestMapping("groupon/list")
    public ResponseVo grouponrulesPage(QueryIn queryIn, String goodsId) {
        ResponseVo responseVo = grouponrulesService.queryGrouponrulesList(queryIn, goodsId);
        return responseVo;
    }

    @RequestMapping("groupon/create")
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
        //改
    @RequestMapping("groupon/update")
    public ErrorVo update(@RequestBody Grouponrules grouponrules) {
        grouponrules.setUpdateTime(new Date());
        try {
            grouponrulesService.update(grouponrules);
            return new ErrorVo(0, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401,"参数不对");
        }
    }
    //删
    @RequestMapping("groupon/delete")
    public ErrorVo delete(@RequestBody Grouponrules grouponrules) {
        Integer id = grouponrules.getId();
        Date updateTime = grouponrules.getUpdateTime();
        try {
            grouponrulesService.delete(id,updateTime);
            return new ErrorVo(0, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401,"删除失败，稍后重试");
        }
    }
    @RequestMapping("groupon/listRecord")
    public ResponseVo grouponActivityPage(QueryIn queryIn, String goodsId) {
        ResponseVo responseVo = grouponActivityService.queryList(queryIn, goodsId);
        return responseVo;
    }

    //前台功能
    //查询
    @RequestMapping("wx/groupon/list")
    public ResponseVo getWxGrouponList(int page, int size) {
        ResponseVo responseVo = grouponrulesService.getWxGrouponList(page, size);
        return responseVo;
    }
}
