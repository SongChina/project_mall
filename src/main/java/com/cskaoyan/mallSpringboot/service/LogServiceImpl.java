package com.cskaoyan.mallSpringboot.service;

import com.cskaoyan.mallSpringboot.bean.Log;
import com.cskaoyan.mallSpringboot.mapper.LogMapper;
import com.cskaoyan.mallSpringboot.renguopingVO.ResultVo;
import com.cskaoyan.mallSpringboot.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;

    ResponseVo responseVo;
    ResultVo resultVo;

    @Override
    public ResponseVo queryList(int page, int limit, String admin) {
        responseVo=new ResponseVo();
        resultVo=new ResultVo();
        if(admin==null){
            PageHelper.startPage(page,limit);
            List<Log> logs=logMapper.queryAllLog();
            PageInfo<Log> pageInfo=new PageInfo<>(logs);
            resultVo.setTotal((int)pageInfo.getTotal());
            resultVo.setItems(pageInfo.getList());
        }else{
            PageHelper.startPage(page,limit);
            List<Log> logs=logMapper.queryByName(admin);
            PageInfo<Log> pageInfo=new PageInfo<>(logs);
            resultVo.setTotal((int)pageInfo.getTotal());
            resultVo.setItems(pageInfo.getList());
        }
        responseVo.setErrno(0);
        responseVo.setData(resultVo);
        responseVo.setErrmsg("成功");
        return responseVo;
    }
}
