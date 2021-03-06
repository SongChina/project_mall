package com.cskaoyan.mallSpringboot.controller.mall;

import com.cskaoyan.mallSpringboot.service.mall.RegionService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionController {

    @Autowired
    RegionService regionService;

    @RequestMapping("admin/region/list")
    public ResponseVo region(String pid){
        ResponseVo responseVo = regionService.getAllRegion(pid);
        return responseVo;
    }

    @RequestMapping("wx/region/list")
    public ResponseVo region2(String pid){
        ResponseVo responseVo = regionService.getAllRegion(pid);
        return responseVo;
    }

}
