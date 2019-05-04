package com.poetry.service.Impl;

import com.poetry.dao.PoemMapper;
import com.poetry.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoemServiceImpl implements PoemService {
    @Autowired
    PoemMapper poemMapper;
}
