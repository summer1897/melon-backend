package com.solstice.melon.config.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/05/11
 * @Time 10:28
 * @Description RedisCacheManager
 */
@Component
public class RedisCacheManager implements CacheManager{

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public Cache<String,String> getCache(String name) throws CacheException {
        return new ShiroRedisCache<String,String>(name,this.redisTemplate);
    }

    public void setRedisTemplate(RedisTemplate<String,String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisTemplate<String, String> getRedisTemplate() {
        return this.redisTemplate;
    }
}
