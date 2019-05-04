package com.poetry.dao;

import com.poetry.pojo.Do.poemDo;

public interface PoemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(poemDo record);

    int insertSelective(poemDo record);

    poemDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(poemDo record);

    int updateByPrimaryKey(poemDo record);
}