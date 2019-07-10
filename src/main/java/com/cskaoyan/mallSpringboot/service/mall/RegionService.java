package com.cskaoyan.mallSpringboot.service.mall;

import com.cskaoyan.mallSpringboot.bean.AddressDetail;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface RegionService {
    ResponseVo getAllRegion(String pid);

    boolean setRegionName(AddressDetail addressDetail);
}
