package com.poetry.service.Impl;

import com.poetry.dao.LikesCollectMapper;
import com.poetry.service.LikesCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesCollectServiceImpl implements LikesCollectService {
    @Autowired
    LikesCollectMapper likesCollectMapper;
}
