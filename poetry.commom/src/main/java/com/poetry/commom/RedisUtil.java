package com.poetry.commom;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class RedisUtil {
    private static RedisTemplate<Serializable, Object> redisTemplate;
    private static RedisTemplate<Serializable, Integer> redisTemplateForzSet;

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public static void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public static void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public static void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public static boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public static Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate
                .opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable,Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, SerializeUtil.serialize(value));
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public  void setRedisTemplate(
            RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    public  void setRedisTemplateForzSet(
            RedisTemplate<Serializable, Integer> redisTemplate) {
        this.redisTemplateForzSet = redisTemplate;
    }

    /**
     * 写入有序集合
     */

    public static boolean incrScore(final String key,int score,int member){
        boolean result=false;
        try {
            redisTemplateForzSet.opsForZSet().incrementScore(key,member,score);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     *获取value对应的score
     */
    public static double score(String key,int value){
        if (exists(key)){
            return redisTemplateForzSet.opsForZSet().score(key, value);
        }else {
            return 0;
        }

    }

    /**
     * 查询集合中指定顺序的值
     */
    public static Set<Integer>  revRange(String key, int start, int end) {
        Set<Integer> result=null;
        try {
            result=redisTemplateForzSet.opsForZSet().reverseRange(key, start, end);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }

    /**
     * 并集
     */
    public static void unionAndStore( List<String> otherKeys, String destKey ) {
        List list=new ArrayList();
        String fistKey=null;
        boolean isFist=true;

        for (String otherKey:otherKeys){
            boolean exist=exists( otherKey);
            if (exist){
                if (isFist){
                    fistKey=otherKey;
                    isFist=false;
                    continue;
                }
                list.add(otherKey);
            }
        }
        try {
           redisTemplateForzSet.opsForZSet().unionAndStore(fistKey, list, destKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除序列
     */
    public static boolean removZSet(String key){
        boolean res=false;
        try {
            long size=redisTemplateForzSet.opsForZSet().size(key);
            redisTemplateForzSet.opsForZSet().removeRange(key,0,size);
            res=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

}
