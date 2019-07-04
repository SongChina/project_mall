package com.cskaoyan.mallSpringboot.service;

import com.cskaoyan.mallSpringboot.bean.System;
import com.cskaoyan.mallSpringboot.bean.SystemExample;
import com.cskaoyan.mallSpringboot.mapper.SystemMapper;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfigService {

    @Autowired(required = false)
    SystemMapper systemMapper;

    public ResponseVo listMall(){
        SystemExample example=new SystemExample();
        /*example.or().andKeyNameLike("cskaoyan_mall_mall_%").andDeletedEqualTo(false);*/
        example.createCriteria().andKeyNameLike("cskaoyan_mall_mall_%");
        List<System> systemList=systemMapper.selectByExample(example);
        Map<String,String> data=new HashMap<>();
        for(System system:systemList){
            data.put(system.getKeyName(),system.getKeyValue());
        }
        return new ResponseVo(0,data,"成功");
    }

    public ResponseVo updateConfig(Map<String,String> data){
        for(Map.Entry<String,String> entry:data.entrySet()) {
            SystemExample example = new SystemExample();
            example.createCriteria().andKeyNameEqualTo(entry.getKey());
            System system=new System();
            system.setKeyName(entry.getKey());
            system.setKeyValue((entry.getValue()));
            system.setUpdateTime(LocalDateTime.now());
            systemMapper.updateByExampleSelective(system,example);
        }
        return new ResponseVo(0,data,"成功");
    }
}
