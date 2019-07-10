package com.cskaoyan.mallSpringboot.service.admin;

import com.cskaoyan.mallSpringboot.bean.Role;
import com.cskaoyan.mallSpringboot.bean.RoleExample;
import com.cskaoyan.mallSpringboot.mapper.RoleMapper;
import com.cskaoyan.mallSpringboot.renguopingVO.OptionVo;
import com.cskaoyan.mallSpringboot.renguopingVO.ResponseVo;
import com.cskaoyan.mallSpringboot.renguopingVO.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    ResponseVo responseVo;
    OptionVo optionVo;
    ResultVo resultVo;


    @Override
    public ResponseVo queryOption() {
        responseVo = new ResponseVo();
        List<OptionVo> data=new ArrayList();
        List<Role> roles=roleMapper.queryAllRole();
        for(Role role:roles) {
            optionVo=new OptionVo();
            optionVo.setValue(role.getId());
            optionVo.setLabel(role.getName());
            data.add(optionVo);
        }
        responseVo.setErrno(0);
        responseVo.setData(data);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

    @Override
    public ResponseVo queryList(int page,int limit,String name, String sort, String order) {
        responseVo = new ResponseVo();
        resultVo = new ResultVo();

        PageHelper.startPage(page,limit);
        RoleExample roleExample = new RoleExample();
        roleExample.setOrderByClause(sort + " " + order);

        if(name==null) {
            List<Role> roles = roleMapper.selectByExample(roleExample);

            PageInfo<Role> pageInfo=new PageInfo<>(roles);
            resultVo.setTotal((int)pageInfo.getTotal());
            resultVo.setItems(pageInfo.getList());

        }else{

            RoleExample.Criteria criteria = roleExample.createCriteria();
            criteria.andNameLike("%" +name + "%");
            List<Role> roles = roleMapper.selectByExample(roleExample);

            PageInfo<Role> pageInfo=new PageInfo<>(roles);
            resultVo.setTotal((int)pageInfo.getTotal());
            resultVo.setItems(pageInfo.getList());

        }
        responseVo.setErrno(0);
        responseVo.setData(resultVo);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

    @Override
    public ResponseVo insertRole(Role role) {
        role.setAddTime(new Date());
        role.setUpdateTime(new Date());
        role.setEnabled(true);
        role.setDeleted(false);
        responseVo=new ResponseVo();
        int insert=roleMapper.insertRole(role);
        if(insert!=0){
            responseVo.setErrno(0);
            responseVo.setData(role);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }

    @Override
    public ResponseVo updateRole(Role role) {
        role.setUpdateTime(new Date());
        responseVo=new ResponseVo();
        int update=roleMapper.updateRole(role);
        if(update!=0){
            responseVo.setErrno(0);
            responseVo.setData(null);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }

    @Override
    public ResponseVo deleteRole(Integer id) {
        responseVo=new ResponseVo();
        int delete=roleMapper.deleteRole(id);
        if(delete!=0){
            responseVo.setErrno(0);
            responseVo.setData(null);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }

}
