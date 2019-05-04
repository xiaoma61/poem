package com.poetry.dao;

import com.poetry.pojo.Do.match_questionDo;

public interface MatchQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(match_questionDo record);

    int insertSelective(match_questionDo record);

    match_questionDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(match_questionDo record);

    int updateByPrimaryKey(match_questionDo record);
}