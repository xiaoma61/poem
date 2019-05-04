package com.poetry.dao;

import com.poetry.pojo.Do.poem_poem_typeDo;

public interface PoemPoemTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(poem_poem_typeDo record);

    int insertSelective(poem_poem_typeDo record);

    poem_poem_typeDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(poem_poem_typeDo record);

    int updateByPrimaryKey(poem_poem_typeDo record);
}