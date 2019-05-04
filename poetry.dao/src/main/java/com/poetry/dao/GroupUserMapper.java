package com.poetry.dao;

import com.poetry.pojo.Do.group_userDo;

public interface GroupUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(group_userDo record);

    int insertSelective(group_userDo record);

    group_userDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(group_userDo record);

    int updateByPrimaryKey(group_userDo record);
}