package com.solstice.melon.config.shiro;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.summer.base.utils.ObjectUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/05/11
 * @Time 10:30
 * @Description 自定义Shiro Redis缓存来存放Shiro会话
 */
public class ShiroRedisCache<K,V> implements Cache<K,V> {

    private static final Logger log = LoggerFactory.getLogger(ShiroRedisCache.class);

    private static final String SHIRO_REDIS_CACHE = "shiro-redis-cache:";
    private String cacheKey;
    private RedisTemplate<String,String> redisTemplate;
    private long globalExpire = 60;

    public ShiroRedisCache(String name,RedisTemplate redisTemplate) {
        this.cacheKey = SHIRO_REDIS_CACHE + name + ":";
        this.redisTemplate = redisTemplate;
    }

    @Override
    public V get(K key) throws CacheException {
        String k = this.getCacheKey(key);

        if (null == k) {
            return null;
        }

        log.debug("Shiro Redis Cache:obtain key: {}",key);
        //设置过期时间,以分钟为计时单位
        this.redisTemplate.boundValueOps(k).expire(globalExpire, TimeUnit.MINUTES);
        return (V)JSON.parseObject(this.redisTemplate.boundValueOps(k).get(),Session.class);
    }

    @Override
    public V put(K key, V value) throws CacheException {
        log.debug("Shiro Redis Cache:set key and value: {},{}",key,value);
        if (null == key && null == value) {
            return null;
        }
        V old = this.get(key);
        this.redisTemplate.boundValueOps(this.getCacheKey(key)).set(JSON.toJSONString(value));
        return old;
    }

    @Override
    public V remove(K key) throws CacheException {
        log.debug("Shiro Redis Cache:remove key: {}",key);
        if (null == key) {
            return null;
        }
        V old = this.get(key);
        this.redisTemplate.delete(this.getCacheKey(key));
        return old;
    }

    @Override
    public void clear() throws CacheException {
        this.redisTemplate.getConnectionFactory().getConnection().flushDb();
    }

    @Override
    public int size() {
        return this.keys().size();
    }

    @Override
    public Set<K> keys() {
        Set<String> keys = this.redisTemplate.keys(this.getCacheKey("*"));
        if (ObjectUtils.isNotEmpty(keys)) {
            return Collections.emptySet();
        }
        Set<K> setKeys = Sets.newHashSet();
        for (String key : keys) {
            setKeys.add((K)key);
        }
        return setKeys;
    }

    @Override
    public Collection values() {
        Set<K> setKeys = this.keys();
        List<V> values = Lists.newArrayList();

        for (K key : setKeys) {
            values.add(this.get(key));
        }
        return values;
    }

    private String getCacheKey(Object k) {
        return this.cacheKey + k.toString();
    }
}
