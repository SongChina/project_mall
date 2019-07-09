package com.cskaoyan.mallSpringboot.controller.user;

import com.cskaoyan.mallSpringboot.service.user.CollectService;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AsidentVoice
 * @date 2019/7/5 17:24
 */
@RestController
public class CollectController {
    @Autowired
    CollectService collectService;

    //会员收藏分类查询
    @RequestMapping("admin/collect/list")
    public ResponseVo collectList(QueryIn queryIn,String userId,String valueId) {
        ResponseVo responseVo = collectService.queryCollectList(queryIn,userId,valueId);
        return responseVo;
    }

}
