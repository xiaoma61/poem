package com.poetry.dao;

import com.poetry.pojo.Do.likes_collectDo;
import com.poetry.pojo.Dto.Likes_CollectionDto;

import java.util.List;

public interface LikesCollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(likes_collectDo record);

    int insertSelective(likes_collectDo record);

    likes_collectDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(likes_collectDo record);

    int updateByPrimaryKey(likes_collectDo record);

    List<Likes_CollectionDto> listLikes_CollectionDto(String id,String type);

    int deleteByUeser_idAndPoem_idAndType(String user_id,Integer poem_id,String type);





}