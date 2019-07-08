package com.cskaoyan.mallSpringboot.config;

import com.cskaoyan.mallSpringboot.shiro.MallShiroSessionManager;
import com.cskaoyan.mallSpringboot.shiro.SuperAdminRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * Created by little Stone
 * Date 2019/7/6 Time 11:28
 */
@Configuration
public class ShiroConfig {

	@Bean
	public DefaultWebSecurityManager securityManager(SuperAdminRealm superAdminRealm, MallShiroSessionManager mallShiroSessionManager){
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(superAdminRealm);
		defaultWebSecurityManager.setSessionManager(mallShiroSessionManager);
		return defaultWebSecurityManager;
	}
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

		shiroFilterFactoryBean.setLoginUrl("/");
		HashMap<String, String> filterMap = new HashMap<>();

		///index.jsp = anon
		//		/login = anon
		//		/logout = logout
		///** = authc
		filterMap.put("/auth/login","anon");
		filterMap.put("/auth/logout","logout");
		//filterMap.put("/user/query","perms[user:query]");
		//filterMap.put("/user/query2","perms[user:query2]");

		filterMap.put("/**","authc");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

		return shiroFilterFactoryBean;
	}


	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager)
	{
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
		return authorizationAttributeSourceAdvisor;
	}

	@Bean
	public MallShiroSessionManager mallShiroSessionManager(){
		MallShiroSessionManager mallShiroSessionManager = new MallShiroSessionManager();
		return mallShiroSessionManager;
	}
}
