package com.poetry.dao;

import com.poetry.pojo.Do.poem_typeDo;

public interface PoemTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(poem_typeDo record);

    int insertSelective(poem_typeDo record);

    poem_typeDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(poem_typeDo record);

    int updateByPrimaryKey(poem_typeDo record);
}