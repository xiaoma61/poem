package com.poetry.dao;

import com.poetry.pojo.Do.likes_collectDo;

public interface LikesCollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(likes_collectDo record);

    int insertSelective(likes_collectDo record);

    likes_collectDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(likes_collectDo record);

    int updateByPrimaryKey(likes_collectDo record);
}