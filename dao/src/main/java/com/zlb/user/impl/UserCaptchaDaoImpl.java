package com.zlb.user.impl;

import cn.joinhealth.hug.model.entity.user.UserCaptcha;
import cn.joinhealth.hug.redis.RedisGeneratorDao;
import cn.joinhealth.hug.redis.user.UserCaptchaDao;
import com.alibaba.fastjson.JSON;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Created by Lubiao Zheng
 * Created time 2018/2/5 16:55
 * Description
 */
@Repository(value = "userCaptchaDao")
public class UserCaptchaDaoImpl extends RedisGeneratorDao implements UserCaptchaDao {

    private static String captchaHash = "CaptchaCode:";

    @Override
    public void add(final UserCaptcha userCaptcha) {
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] keyInfo = serializer.serialize(captchaHash + userCaptcha.getCaptchaId());
                redisConnection.set(keyInfo, serializer.serialize(JSON.toJSONString(userCaptcha)));
                return null;
            }
        });
        redisTemplate.expire(captchaHash + userCaptcha.getCaptchaId(), 1, TimeUnit.MINUTES);
    }

    @Override
    public UserCaptcha get(final String captchaId) {
        return (UserCaptcha) redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key;
                byte[] value;
                key = serializer.serialize(captchaHash + captchaId);
                value = redisConnection.get(key);
                if (value == null) {
                    return null;
                }
                return JSON.parseObject(serializer.deserialize(value), UserCaptcha.class);
            }
        });
    }
}
