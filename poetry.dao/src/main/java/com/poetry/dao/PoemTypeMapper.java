package com.poetry.dao;

import com.poetry.pojo.Do.poem_typeDo;

import java.util.List;

public interface PoemTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(poem_typeDo record);

    int insertSelective(poem_typeDo record);

    poem_typeDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(poem_typeDo record);

    int updateByPrimaryKey(poem_typeDo record);

    List<poem_typeDo> listPoem_typeDo();




}