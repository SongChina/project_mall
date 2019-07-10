package com.cskaoyan.mallSpringboot.service.mall.impl;

import com.cskaoyan.mallSpringboot.bean.AddressDetail;
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

    @Override
    public boolean setRegionName(AddressDetail addressDetail) {
        //根据addressDetail中的地区id进行选择
        RegionExample regionExample = new RegionExample();
        RegionExample.Criteria criteria = regionExample.createCriteria();
        criteria.andCodeEqualTo(addressDetail.getProvinceId());
        List<Region> regions = regionMapper.selectByExample(regionExample);
        addressDetail.setProvinceName(regions.get(0).getName());
        regionExample.clear();

        RegionExample.Criteria criteria2 = regionExample.createCriteria();
        criteria2.andCodeEqualTo(addressDetail.getAreaId());
        List<Region> regions2 = regionMapper.selectByExample(regionExample);
        addressDetail.setAreaName(regions2.get(0).getName());
        regionExample.clear();

        RegionExample.Criteria criteria3 = regionExample.createCriteria();
        criteria3.andCodeEqualTo(addressDetail.getCityId());
        List<Region> regions3 = regionMapper.selectByExample(regionExample);
        addressDetail.setCityName(regions3.get(0).getName());
        regionExample.clear();

        return true;
    }
}
