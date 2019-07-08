package com.cskaoyan.mallSpringboot.controller.promotion;

import com.cskaoyan.mallSpringboot.bean.Ad;
import com.cskaoyan.mallSpringboot.service.promotion.AdService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.cskaoyan.mallSpringboot.vo.promotion.ErrorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

;

@RestController
@RequestMapping("ad")
public class AdvertisementController {
    @Autowired
    AdService adService;

    @RequestMapping("list")
    public ResponseVo adList(QueryIn queryIn, String name, String content) {
        return adService.queryList(queryIn,name,content);
    }
    @RequestMapping("create")
    public Object createAd(@RequestBody Ad ad){
        try {
            Ad data = adService.createAd(ad);
            return new ResponseVo(0,data,"成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401,"参数不对");
        }
    }

    @RequestMapping("update")
    public Object update(@RequestBody Ad ad){
        ad.setUpdateTime(new Date());
        ad.setDeleted(false);
        try {
            adService.update(ad);
            return new ResponseVo(0, ad,"成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401,"参数不对");
        }
    }

    @RequestMapping("delete")
    public ErrorVo delete(@RequestBody Ad ad) {
        Integer id = ad.getId();
        Date updateTime = ad.getUpdateTime();
        try {
            adService.delete(id,updateTime);
            return new ErrorVo(0, "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorVo(401,"删除失败，稍后重试");
        }
    }
}
