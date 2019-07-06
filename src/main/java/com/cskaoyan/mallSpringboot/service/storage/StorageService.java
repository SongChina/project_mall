package com.cskaoyan.mallSpringboot.service.storage;

import com.cskaoyan.mallSpringboot.bean.Storage;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface StorageService {
    ResponseVo storageCreate(Storage storage);
}
