package com.cskaoyan.mallSpringboot.controller.storage;

import com.cskaoyan.mallSpringboot.service.storage.StorageService;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    @RequestMapping("create")
    public ResponseVo storageCreate(MultipartFile file){
        return null;
    }

}
