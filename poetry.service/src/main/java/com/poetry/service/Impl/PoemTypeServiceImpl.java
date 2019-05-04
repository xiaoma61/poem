package com.poetry.service.Impl;

import com.poetry.dao.PoemMapper;
import com.poetry.service.PoemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoemTypeServiceImpl implements PoemTypeService {
    @Autowired
    PoemMapper poemMapper;

}
