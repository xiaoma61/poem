package com.poetry.service.Impl;

import com.poetry.dao.MatchQuestionMapper;
import com.poetry.service.MatchQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchQuestionServiceImpl implements MatchQuestionService {
    @Autowired
    MatchQuestionMapper matchQuestionMapper;
}
