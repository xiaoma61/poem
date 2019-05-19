package com.poetry.service.Impl;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.poetry.commom.R;
import com.poetry.dao.PoemMapper;
import com.poetry.dao.redis.RedisUtil;
import com.poetry.pojo.Do.poem_typeDo;
import com.poetry.pojo.Dto.*;
import com.poetry.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.poetry.commom.constant.Constants.*;
import static com.poetry.dao.RedisKeyConstants.RedisKeyConstants.REAK_HOT_BY_Q;
import static com.poetry.dao.RedisKeyConstants.RedisKeyConstants.REAK_RECENT_BY_Q;
import static com.poetry.dao.RedisKeyConstants.RedisKeyConstants.REAK_TYPE_BY_Q;


@Service
public class PoemServiceImpl implements PoemService {
    @Autowired
    PoemMapper poemMapper;
    @Autowired
    RedisUtil redisUtil;
    private HashSet<Object> set;


    @Override
    public PeopleRegisterDto getPeopleRegisterDto() {
        return poemMapper.getPeopleRegisterDto();
    }

    @Override
    public List<PoemDto> listPoemDto(String q, String type) {
        return poemMapper.listPoemDto(q,type);
    }

    @Override
    public void recordSearch(String q,String  id) {

        //记录热门搜索记录
        redisUtil.incrementScore(REAK_HOT_BY_Q,q,1);
        //记录个人纪录
        //id+ json q:
        QDto dto=new QDto();
        dto.setQ(q);
        postRecent(id,dto);
    }

    @Override
    public Set<String> getHotSearch(int type) {
        if (type==qHot){
            return redisUtil.reverseRank(REAK_HOT_BY_Q,START, ROW);
        }
        if (type==typeHot){
            return redisUtil.reverseRank(REAK_TYPE_BY_Q,START, ROW);

        }
        return null;

    }

    @Override
    public R getRecentSearch(String id) {
        set=new HashSet<>();
        return getRecent(id);

    }

    @Override
    public  List<PoemTypeDto> getPoemTypeDto(int id) {
        return poemMapper.getPoemTypeDto(id);
    }

    @Override
    public void recordType(Integer type_id,String poemType) {
        poem_typeDo poemTypeDo=new poem_typeDo();
        poemTypeDo.setId(type_id);
        poemTypeDo.setPoemTypeName(poemType);

        redisUtil.incrementScore(REAK_TYPE_BY_Q, JSONObject.toJSON(poemTypeDo).toString(),1);
    }

    @Override
    public PoemLikeCollectionDto getPoemLikeCollectionDto(String user_id, int poem_id) {

        return poemMapper.getPoemLikeCollectionDto(user_id, poem_id);

    }

    @Override
    public List<PoemReadRecordDto> listPoemReadRecordDtoResultMap(int id,String user_id) {
        return poemMapper.listPoemReadRecordDtoResultMap(id,user_id);
    }


    private void postRecent(String id,QDto dto){

        set=new HashSet<>();
        getRecent(id);
        set.add(dto.getQ());
        redisUtil.hset(REAK_RECENT_BY_Q,id, JSONObject.toJSON(set));
    }

    private R getRecent(String id){
        Object object=redisUtil.hget(REAK_RECENT_BY_Q,id);
        if (object==null){
            return null;
        }
        String str=JSONObject.toJSONString(object);

        try {
            List list=JSONObject.parseArray(str);
            for (int i=0;i<SIZE&&i<list.size();i++){
                set.add(list.get(i));
            }
            return R.ok(set);


        }catch (JSONException j){

            set.add(JSONObject.parseObject(str,QDto.class).getQ());
            return R.ok(JSONObject.parseObject(str,QDto.class).getQ());
        }


    }
}
