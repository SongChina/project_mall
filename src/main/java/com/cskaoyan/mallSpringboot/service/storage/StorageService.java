package com.cskaoyan.mallSpringboot.service.storage;

import com.cskaoyan.mallSpringboot.bean.Storage;
import com.cskaoyan.mallSpringboot.vo.QueryIn;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;

public interface StorageService {
    ResponseVo storageCreate(Storage storage);

    ResponseVo storageList(QueryIn queryIn, String key, String name);

    ResponseVo storageUpdate(Storage storage);

    ResponseVo storageDelete(Storage storage);

    ResponseVo storageUpload(Storage storage);
}
