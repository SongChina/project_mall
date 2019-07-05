package com.cskaoyan.mallSpringboot.controller.config;

import com.cskaoyan.mallSpringboot.service.ConfigService;
import com.cskaoyan.mallSpringboot.util.JacksonUtil;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("config")
public class ConfigController {

    @Autowired
    ConfigService configService;

    @GetMapping("/mall")
    public ResponseVo listMall(){
        ResponseVo responseVo=configService.listMall();
        return responseVo;
    }
    @PostMapping("/mall")
    public ResponseVo updataMall(@RequestBody String body){
        Map<String,String> data= JacksonUtil.toMap(body);
        ResponseVo responseVo=configService.updateConfig(data);
        return responseVo;
    }
}
