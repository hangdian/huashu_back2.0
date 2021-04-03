package com.huashu.monitor.shiro.cache;

import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * @Description
 * @auther supermao
 * @create 2021-03-17 13:51
 */
public class RedisCacheManager implements CacheManager {

    @Override
    public <K, V> RedisCache getCache(String cacheName) throws CacheException {
//        System.out.println("缓存名称: " + cacheName);
        return new RedisCache(cacheName);
    }
}
