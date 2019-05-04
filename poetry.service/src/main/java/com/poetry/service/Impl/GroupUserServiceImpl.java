package com.poetry.service.Impl;

import com.poetry.dao.GroupUserMapper;
import com.poetry.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupUserServiceImpl implements GroupUserService {
    @Autowired
    GroupUserMapper groupUserMapper;
}
