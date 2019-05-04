package com.poetry.dao;

import com.poetry.pojo.Do.match_recordDo;

public interface MatchRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(match_recordDo record);

    int insertSelective(match_recordDo record);

    match_recordDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(match_recordDo record);

    int updateByPrimaryKey(match_recordDo record);
}