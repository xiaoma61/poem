package com.poetry.service;

import com.poetry.pojo.Do.likes_collectDo;
import com.poetry.pojo.Dto.Likes_CollectionDto;

import java.util.List;

public interface LikesCollectService {

    List<Likes_CollectionDto> listLikes_CollectionDto(String id, String type);

    int insert(likes_collectDo record);

    int deleteByUeser_idAndPoem_idAndType(String user_id,Integer poem_id,String type);

    int like_collect(likes_collectDo record,int type,boolean like);

}
