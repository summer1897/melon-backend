package com.solstice.melon.config.shiro;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Intellij IDEA
 *
 * @Projcet civil-air-defence
 * @Author summer
 * @Date 2018/4/18
 * @Time 10:33
 * @Description {@link RedisSessionDao}
 */
//@Component
public class RedisSessionDao extends EnterpriseCacheSessionDAO {

    private static final Logger log = LoggerFactory.getLogger(RedisSessionDao.class);

    //session在Redis中的过期时间 60*60，即60分钟
    private static final int EXPIRE_TIME = 60 * 60;
    private static final String PREFIS = "shiro-redis-session";

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 创建Session，并持久化到数据库
     * @param session
     * @return
     */
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        log.debug("创建session:{}",session.getId());
        this.redisTemplate.opsForValue().set(this.getKey(sessionId), JSON.toJSONString(session));
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        log.debug("获取session:{}",sessionId);
        Session session = super.doReadSession(sessionId);

        //先从缓存中读取session,如果缓存中没有再去数据库从读取
        if (null == session) {
//            session = (Session) this.redisTemplate.opsForValue().get(this.getKey(sessionId));
            session = JSON.parseObject(this.redisTemplate.opsForValue().get(this.getKey(sessionId)),Session.class);
        }
        return session;
    }

    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        log.debug("更新session:{}",session.getId());
        String key  = this.getKey(session.getId());
        if (!this.redisTemplate.hasKey(key)) {
            this.redisTemplate.opsForValue().set(key,JSON.toJSONString(session));
        }
        this.redisTemplate.expire(key,EXPIRE_TIME, TimeUnit.SECONDS);
    }

    @Override
    protected void doDelete(Session session) {
        log.debug("删除session:{}",session.getId());
        super.doDelete(session);
        this.redisTemplate.delete(this.getKey(session.getId()));
    }

    private String getKey(Serializable sessionId) {
        return sessionId.toString() + PREFIS;
    }

}
