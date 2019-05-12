package com.poetry.service;

import com.poetry.pojo.Dto.Likes_CollectionDto;

import java.util.List;

public interface LikesCollectService {
    List<Likes_CollectionDto> listLikes_CollectionDto(String id, String type);
}
