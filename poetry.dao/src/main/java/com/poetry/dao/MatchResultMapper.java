package com.poetry.dao;

import com.poetry.pojo.Do.match_resultDo;
import com.poetry.pojo.Do.match_resultKey;

public interface MatchResultMapper {
    int deleteByPrimaryKey(match_resultKey key);

    int insert(match_resultDo record);

    int insertSelective(match_resultDo record);

    match_resultDo selectByPrimaryKey(match_resultKey key);

    int updateByPrimaryKeySelective(match_resultDo record);

    int updateByPrimaryKey(match_resultDo record);
}