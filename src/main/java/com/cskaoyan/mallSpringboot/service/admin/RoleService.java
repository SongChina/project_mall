package com.cskaoyan.mallSpringboot.service.admin;

import com.cskaoyan.mallSpringboot.bean.Role;
import com.cskaoyan.mallSpringboot.renguopingVO.ResponseVo;

import java.util.List;

public interface RoleService {
    //处理option请求的返回
    ResponseVo queryOption();
    //查询所有角色或根据名称模糊查询
    ResponseVo queryList(int page,int limit,String name,String sort, String order);
    //增加角色
    ResponseVo insertRole(Role role);
    //编辑角色
    ResponseVo updateRole(Role role);
    //删除角色
    ResponseVo deleteRole(Integer id);

    List<String> queryRoleRightsInRoleId(int roleId);
}
