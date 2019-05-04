package com.poetry.service.Impl;

import com.poetry.dao.PostCommentMapper;
import com.poetry.service.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCommentServiceImpl implements PostCommentService {
    @Autowired
    PostCommentMapper postCommentMapper;

}
