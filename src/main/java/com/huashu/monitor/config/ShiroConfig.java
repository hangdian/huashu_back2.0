package com.huashu.monitor.config;

import com.huashu.monitor.shiro.cache.RedisCacheManager;
import com.huashu.monitor.shiro.filter.AuthFilter;
import com.huashu.monitor.shiro.realms.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther supermao
 * @create 2021-03-15 15:46
 */
@Configuration
public class ShiroConfig {

    // 创建shiroFilter 负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        // 给filter设置安全管理器
        shiroFilter.setSecurityManager(defaultWebSecurityManager);
        Map<String, Filter> filters = shiroFilter.getFilters();
        filters.put("authc", new AuthFilter());

        // 配置系统受限资源
        // 配置系统公共资源
        Map<String, String> filterMap = new HashMap<>();
        // anno 匿名访问  auth 验证
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/user/login", "anon");
        filterMap.put("/user/register", "anon");
        filterMap.put("/swagger/**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/doc.html", "anon");
        filterMap.put("/webSocket/**", "anon");

        // 除了以上路径，其他都需要权限验证
        filterMap.put("/**", "authc");

        shiroFilter.setFilterChainDefinitionMap(filterMap);

        return shiroFilter;
    }

    // 创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("customerRealm") Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("rememberme");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(30 * 60); // 记住我功能默认30分钟
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(simpleCookie);
        defaultWebSecurityManager.setRememberMeManager(cookieRememberMeManager);
        return defaultWebSecurityManager;
    }

    // 创建自定义realm
    @Bean(name = "customerRealm")
    public Realm getRealm() {
        CustomerRealm customerRealm = new CustomerRealm();
        // 修改凭证校验匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        // 设置加密算法为md5
        credentialsMatcher.setHashAlgorithmName("MD5");
        // 设置散列次数
        credentialsMatcher.setHashIterations(1024);
        customerRealm.setCredentialsMatcher(credentialsMatcher);
        // 开启缓存管理(EhCacheManager缓存在本地)
//        customerRealm.setCacheManager(new EhCacheManager());
        customerRealm.setCacheManager(new RedisCacheManager());
        customerRealm.setCachingEnabled(true);// 开启全局缓存
        customerRealm.setAuthenticationCachingEnabled(true);// 开启认证缓存
        customerRealm.setAuthenticationCacheName("authenticationCache");
        customerRealm.setAuthorizationCachingEnabled(true);// 开启授权缓存
        customerRealm.setAuthorizationCacheName("authorizationCache");
        return customerRealm;
    }


}
