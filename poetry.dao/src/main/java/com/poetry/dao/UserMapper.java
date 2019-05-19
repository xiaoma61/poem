package com.poetry.dao;

import com.poetry.pojo.Do.userDo;


public interface UserMapper {


    int deleteByPrimaryKey(String id);

    int insert(userDo record);

    int insertSelective(userDo record);

    userDo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(userDo record);

    int updateByPrimaryKey(userDo record);
}