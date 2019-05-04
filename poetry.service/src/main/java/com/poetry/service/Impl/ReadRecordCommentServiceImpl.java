package com.poetry.service.Impl;

import com.poetry.dao.ReadRecordCommentMapper;
import com.poetry.service.ReadRecordCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadRecordCommentServiceImpl implements ReadRecordCommentService {
    @Autowired
    ReadRecordCommentMapper readRecordCommentMapper;
}
