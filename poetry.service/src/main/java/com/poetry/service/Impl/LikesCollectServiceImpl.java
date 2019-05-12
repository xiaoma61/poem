package com.poetry.service.Impl;

import com.poetry.dao.LikesCollectMapper;
import com.poetry.pojo.Dto.Likes_CollectionDto;
import com.poetry.service.LikesCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesCollectServiceImpl implements LikesCollectService {
    @Autowired
    LikesCollectMapper likesCollectMapper;

    @Override
    public List<Likes_CollectionDto> listLikes_CollectionDto(String id, String type) {
        return likesCollectMapper.listLikes_CollectionDto(id, type);
    }
}
