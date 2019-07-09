package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Storage;
import com.cskaoyan.mallSpringboot.bean.StorageExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StorageMapper {

    int storageInsert(Storage storage);

    Storage selectStorageById(Integer id);

    List<Storage> selectStorageList(@Param("key") String key, @Param("name") String name);

    int storageUpdate(Storage storage);

    int storageDelete(Storage storage);

//    int storageUpload(Storage storage);

    //以上是新增的
    long countByExample(StorageExample example);

    int deleteByExample(StorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    List<Storage> selectByExample(StorageExample example);

    Storage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByExample(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);


}