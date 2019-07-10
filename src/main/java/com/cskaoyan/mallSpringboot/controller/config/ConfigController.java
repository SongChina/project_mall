package com.cskaoyan.mallSpringboot.controller.config;

import com.cskaoyan.mallSpringboot.service.config.ConfigService;
import com.cskaoyan.mallSpringboot.util.JacksonUtil;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ConfigController {

    @Autowired
    ConfigService configService;

    @GetMapping("admin/config/mall")
    public ResponseVo listMall(){
        ResponseVo responseVo=configService.listMall();
        return responseVo;
    }
    @PostMapping("admin/config/mall")
    public ResponseVo updataMall(@RequestBody String body){
        Map<String,String> data= JacksonUtil.toMap(body);
        ResponseVo responseVo=configService.updateConfig(data);
        return responseVo;
    }

    @GetMapping("admin/config/express")
    public ResponseVo listExpress(){
        ResponseVo responseVo=configService.listExpress();
        return responseVo;
    }
    @PostMapping("admin/config/express")
    public ResponseVo updataExpress(@RequestBody String body){
        Map<String,String> data= JacksonUtil.toMap(body);
        ResponseVo responseVo=configService.updateConfig(data);
        return responseVo;
    }

    @GetMapping("admin/config/order")
    public ResponseVo listOrder(){
        ResponseVo responseVo=configService.listOrder();
        return responseVo;
    }
    @PostMapping("admin/config/order")
    public ResponseVo updataOrder(@RequestBody String body){
        Map<String,String> data= JacksonUtil.toMap(body);
        ResponseVo responseVo=configService.updateConfig(data);
        return responseVo;
    }

    @GetMapping("admin/config/wx")
    public ResponseVo listWx(){
        ResponseVo responseVo=configService.listWx();
        return responseVo;
    }
    @PostMapping("admin/config/wx")
    public ResponseVo updataWx(@RequestBody String body){
        Map<String,String> data= JacksonUtil.toMap(body);
        ResponseVo responseVo=configService.updateConfig(data);
        return responseVo;
    }
}
