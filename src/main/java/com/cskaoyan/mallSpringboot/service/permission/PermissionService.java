package com.cskaoyan.mallSpringboot.service.permission;

import java.util.List;

public interface PermissionService {
    boolean updatePermissionsByRoleId(int roleId, List<String> permissions);
}
