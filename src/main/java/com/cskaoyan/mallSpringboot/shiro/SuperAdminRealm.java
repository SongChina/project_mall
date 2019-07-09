package com.cskaoyan.mallSpringboot.shiro;

import com.cskaoyan.mallSpringboot.bean.Admin;
import com.cskaoyan.mallSpringboot.bean.AdminExample;
import com.cskaoyan.mallSpringboot.bean.Role;
import com.cskaoyan.mallSpringboot.bean.RoleExample;
import com.cskaoyan.mallSpringboot.mapper.AdminMapper;
import com.cskaoyan.mallSpringboot.mapper.RoleMapper;
import com.cskaoyan.mallSpringboot.service.shiro.ShiroService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by little Stone
 * Date 2019/7/6 Time 9:46
 */
@Component("superAdminRealm")
public class SuperAdminRealm extends AuthorizingRealm {
//
	@Autowired
	AdminMapper adminMapper;

	@Autowired
	RoleMapper roleMapper;

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		//关注凭证（密码）
		//执行验证的用户名
		String principal = (String) authenticationToken.getPrincipal();
		//根据用户名将该管理员的所有信息返回
		AdminExample adminExample = new AdminExample();
		AdminExample.Criteria criteria = adminExample.createCriteria();
		criteria.andUsernameEqualTo(principal);
		List<Admin> admins = adminMapper.selectByExample(adminExample);
		//通常情况按照名字进行查询只存在一个合格的管理员
		Admin adminInDb = admins.get(0);

		//参数1：principle是要给到授权使用的
		//参数2：通常写来源于数据库的密码 如果和subject。login中token的密码匹配 才能通过认证
		//参数3：当前的域名（基本没用）
		//封装用户信息，构建AuthenticationInfo对象并返回
		AuthenticationInfo info = new SimpleAuthenticationInfo(adminInDb, adminInDb.getPassword() , "realm");
		return info;
	}

	@Autowired
	ShiroService shiroService;
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//来源于SimpleAuthenticationInfo的第一个参数，可以是String类型，也可以是Javabean
		Admin admin= (Admin) principalCollection.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//从数据库中取出 当前用户的授权信息（可以查询role，也可以查询permission）
		/*List<Integer> intIds = new ArrayList<>();
		int i = 0;
		int[] roleIds = admin.getRoleIds();
		for (int roleId : roleIds) {
			intIds.set(i, roleId);
			i ++;
		}
		RoleExample roleExample = new RoleExample();
		RoleExample.Criteria criteria = roleExample.createCriteria();
		criteria.andIdIn(intIds);
		List<Role> roles = roleMapper.selectByExample(roleExample);

		Set<String> roleSet = new HashSet<>();
		//根据admin的roleId对表cskaoyan_mall_role中进行查询，将其转化为中文的名字
		for (Role role : roles) {
			roleSet.add(role.getName());
		}
		info.addRoles(roleSet);*/

		List<String> allPermission = shiroService.getAllPermission(admin.getRoleIds());
		for (String s : allPermission) {
			info.addStringPermission(s);
		}

		HashSet<String> roleSet = new HashSet<>();
		List<String> allRolesInChinese = shiroService.getAllRolesInChinese(admin.getRoleIds());
		for (String s : allRolesInChinese) {
			roleSet.add(s);
		}
		info.addRoles(roleSet);

		//info.addStringPermission("user:query");

		return info;
	}

}
