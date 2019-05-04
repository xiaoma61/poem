package com.poetry.service.Impl;

import com.poetry.dao.PoemPoemTypeMapper;
import com.poetry.service.PoemPoemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoemPoemTypeServiceImpl implements PoemPoemTypeService {
    @Autowired
    PoemPoemTypeMapper poemPoemTypeMapper;
}
