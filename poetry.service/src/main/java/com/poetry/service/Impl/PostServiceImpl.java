package com.poetry.service.Impl;


import com.poetry.dao.PostMapper;

import com.poetry.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;

}
