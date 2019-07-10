package com.cskaoyan.mallSpringboot.service.permission.impl;

import com.cskaoyan.mallSpringboot.bean.Permission;
import com.cskaoyan.mallSpringboot.bean.PermissionExample;
import com.cskaoyan.mallSpringboot.mapper.PermissionMapper;
import com.cskaoyan.mallSpringboot.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public boolean updatePermissionsByRoleId(int roleId, List<String> permissions) {
        //首先将roleId对应的权限全部拿出来，然后再一条一条和要添加的比较，如果没有就加入
        PermissionExample permissionExample = new PermissionExample();
        PermissionExample.Criteria criteria = permissionExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        int i = permissionMapper.deleteByExample(permissionExample);

        if(i >= 0) {
            List<Permission> addPermissions = new ArrayList<>();
            for (String permission : permissions) {
                    Permission temp = new Permission();
                    temp.setRoleId(roleId);
                    temp.setPermission(permission);
                    addPermissions.add(temp);
            }
            permissionMapper.insertInBatch(addPermissions);
            return true;
        }
        else{
            return false;
        }

    }
}
