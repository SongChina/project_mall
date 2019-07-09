package com.cskaoyan.mallSpringboot.service.mall.impl;

import com.cskaoyan.mallSpringboot.bean.Region;
import com.cskaoyan.mallSpringboot.bean.RegionExample;
import com.cskaoyan.mallSpringboot.mapper.RegionMapper;
import com.cskaoyan.mallSpringboot.service.mall.RegionService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionMapper regionMapper;

    @Override
    public ResponseVo getAllRegion(String pid) {
        if(pid == null){
            List<Region> provinces = regionMapper.queryProvince();
            for (int i = 0; i < provinces.size(); i++) {
                Region province = provinces.get(i);
                int code = province.getCode();
                List<Region> cities = regionMapper.queryCity(code+"%");
                for (int j = 0; j < cities.size(); j++) {
                    Region city = cities.get(j);
                    int code1 = city.getCode();
                    List<Region> districts = regionMapper.queryDistrict(code1+"%");
                    city.setChildren(districts);
                }
                province.setChildren(cities);
            }
            return new ResponseVo(0, provinces, "成功");
        }else {
            List<Region> regionList = regionMapper.queryByPid(pid);
            return new ResponseVo(0, regionList, "成功");
        }

    }
}
