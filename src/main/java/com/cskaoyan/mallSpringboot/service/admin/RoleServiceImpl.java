package com.cskaoyan.mallSpringboot.service.admin;

import com.cskaoyan.mallSpringboot.bean.Permission;
import com.cskaoyan.mallSpringboot.bean.PermissionExample;
import com.cskaoyan.mallSpringboot.bean.Role;
import com.cskaoyan.mallSpringboot.bean.RoleExample;
import com.cskaoyan.mallSpringboot.mapper.PermissionMapper;
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

    @Autowired
    PermissionMapper permissionMapper;

    public static final String[] allPermissions = {"admin:order:list", "admin:admin:update", "admin:coupon:delete", "admin:topic:read", "admin:admin:delete", "admin:user:list", "admin:goods:update", "admin:role:permission:get", "admin:brand:update", "admin:category:create", "admin:coupon:list", "admin:ad:create", "admin:stat:order", "admin:config:wx:updateConfigs", "admin:topic:list", "admin:order:refund", "admin:order:read", "admin:topic:delete", "admin:brand:list", "admin:coupon:update", "admin:brand:delete", "admin:brand:read", "admin:config:wx:list", "admin:collect:list", "admin:storage:list", "admin:coupon:listuser", "admin:groupon:read", "admin:admin:read", "admin:storage:read", "admin:order:ship", "admin:keyword:update", "admin:comment:delete", "admin:groupon:create", "admin:comment:list", "admin:keyword:list", "admin:keyword:create", "admin:admin:list", "admin:history:list", "admin:category:delete", "admin:role:delete", "admin:storage:delete", "admin:keyword:read", "admin:order:reply", "admin:goods:delete", "admin:ad:delete", "admin:issue:update", "admin:address:list", "admin:topic:create", "admin:category:read", "admin:category:update", "admin:storage:create", "admin:config:express:updateConfigs", "admin:brand:create", "admin:issue:delete", "admin:config:express:list", "admin:goods:create", "admin:ad:list", "admin:role:permission:update", "admin:groupon:list", "admin:admin:create", "admin:groupon:update", "admin:footprint:list", "index:permission:write", "admin:groupon:delete", "admin:ad:read", "admin:config:order:list", "index:permission:read", "admin:keyword:delete", "admin:role:create", "admin:issue:list", "admin:log:list", "admin:config:order:updateConfigs", "admin:topic:update", "admin:config:mall:list", "admin:category:list", "admin:stat:goods", "admin:issue:create", "admin:role:update", "admin:config:mall:updateConfigs", "admin:stat:user", "admin:coupon:read", "admin:coupon:create", "admin:goods:list", "admin:ad:update", "admin:role:list", "admin:storage:update", "admin:role:read", "admin:feedback:list", "admin:goods:read"};
    @Override
    public List<String> queryRoleRightsInRoleId(int roleId) {
        PermissionExample permissionExample = new PermissionExample();
        PermissionExample.Criteria criteria = permissionExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<Permission> permissions = permissionMapper.selectByExample(permissionExample);
        ArrayList<String> assignedPerms = new ArrayList<>();
        for (Permission permission : permissions) {
            if("*".equals(permission.getPermission())){
                for(int i =0 ; i < allPermissions.length ; i ++){
                    assignedPerms.add(allPermissions[i]);
                }
                break;
            }
            assignedPerms.add(permission.getPermission());
        }
        return assignedPerms;
    }

}
