package com.poetry.dao.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.io.*;
import java.util.Set;
import org.springframework.data.redis.core.ValueOperations;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtil {
    @Autowired
    private RedisTemplate<String,String> clusterRedisTemplate;

    private static RedisTemplate<Serializable, Object> redisTemplate;
    private static RedisTemplate<Serializable, Integer> redisTemplateForzSet;

    public void put(Object key, Object value){
        if (null==value){
            return;
        }
        if (value instanceof  String){
            if (StringUtils.isEmpty(value.toString())){
                return;
            }
        }
        final String keyf = key + "";
        final Object valuef = value;
        final long liveTime = 86400;
        clusterRedisTemplate.execute((RedisCallback<Long>) connection -> {
                      byte[] keyb = keyf.getBytes();byte[] valueb = toByteArray(valuef);
                      connection.set(keyb, valueb);
                      if (liveTime > 0) {
                          connection.expire(keyb, liveTime);
                      }return 1L; });

    }
    public void lpush(String key,String Object){
        clusterRedisTemplate.opsForList().leftPush(key,Object);
    }
    public void incrementScore(String k,String v,double v1 ){
        clusterRedisTemplate.opsForZSet().incrementScore(k,v,v1);
    }
    public double score(String v,String key){
        return clusterRedisTemplate.opsForZSet().score(v, key);

    }
    public long opsForZSetzCard(String k){

        return clusterRedisTemplate.opsForZSet().zCard(k);
    }
    public void opsForZsetadd(String k,String key,double s){
        clusterRedisTemplate.opsForZSet().add(k, key,s);
    }
    public Set<String> reverseRank(String key, int start, int  rows){
        return clusterRedisTemplate.opsForZSet().reverseRange(key,start,rows);
    }

    public Set<ZSetOperations.TypedTuple<String>>reverseRangeWithScores(String k,int s,int r){
        return clusterRedisTemplate.opsForZSet().reverseRangeWithScores(k,s,r);

}

    public void set(String key,String value){
        clusterRedisTemplate.opsForSet().add(key,value);
    }
    public Set<String>member(String key){
       return clusterRedisTemplate.opsForSet().members(key);
    }
    public  boolean hasKey(Object key){

        return clusterRedisTemplate.hasKey((String) key);
    }
    public Object get(Object key) {
        final String keyf = (String) key;
        Object object;

        object = clusterRedisTemplate.execute((RedisCallback<Object>) connection -> {
            byte[] key1 = keyf.getBytes();
            byte[] value = connection.get(key1);
            if (value == null) {
                return null;
            }return toObject(value);
        });
        return object;
    }

    private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
            } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

     private Object toObject(byte[] bytes) {
        Object obj = null;

        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }

    public void hset(String key,String field,Object value){
        clusterRedisTemplate.opsForHash().put(key,field,value);
    }

    public Object hget(String key, String field){

        return clusterRedisTemplate.opsForHash().get(key,field);

    }


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
            if (null!=redisTemplateForzSet.opsForZSet().score(key, value)){
                return redisTemplateForzSet.opsForZSet().score(key, value);

            }else {

                return 0;
            }


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
            if (list!=null&&list.size()>0){
                redisTemplateForzSet.opsForZSet().unionAndStore(fistKey, list, destKey);
            }


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
