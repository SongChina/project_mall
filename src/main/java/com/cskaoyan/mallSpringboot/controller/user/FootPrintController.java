package com.cskaoyan.mallSpringboot.controller.user;

import com.cskaoyan.mallSpringboot.service.user.FootPrintService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AsidentVoice
 * @date 2019/7/6 14:46
 */
@RestController
public class FootPrintController {
    @Autowired
    FootPrintService footPrintService;

    //会员足迹分类查询
    @RequestMapping("footprint/list")
    public ResponseVo footprintList(QueryIn queryIn,String userId,String goodsId){
        ResponseVo responseVo = footPrintService.queryFootPrintList(queryIn,userId,goodsId);
        return responseVo;
    }
}
