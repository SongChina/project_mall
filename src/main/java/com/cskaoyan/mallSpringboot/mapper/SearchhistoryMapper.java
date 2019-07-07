package com.cskaoyan.mallSpringboot.mapper;

import com.cskaoyan.mallSpringboot.bean.Searchhistory;
import com.cskaoyan.mallSpringboot.bean.SearchhistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchhistoryMapper {

    int querySearchHistoryCount(@Param("userId") String userId,@Param("keyword") String keyword);
    List<Searchhistory> querySearchHistoryList(@Param("userId") String userId,@Param("keyword") String keyword);

//    以上是新增的
    long countByExample(SearchhistoryExample example);

    int deleteByExample(SearchhistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Searchhistory record);

    int insertSelective(Searchhistory record);

    List<Searchhistory> selectByExample(SearchhistoryExample example);

    Searchhistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Searchhistory record, @Param("example") SearchhistoryExample example);

    int updateByExample(@Param("record") Searchhistory record, @Param("example") SearchhistoryExample example);

    int updateByPrimaryKeySelective(Searchhistory record);

    int updateByPrimaryKey(Searchhistory record);
}