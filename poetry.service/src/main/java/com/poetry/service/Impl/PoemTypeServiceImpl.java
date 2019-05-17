package com.poetry.service.Impl;

import com.poetry.dao.PoemMapper;
import com.poetry.dao.PoemTypeMapper;
import com.poetry.pojo.Do.poem_typeDo;
import com.poetry.service.PoemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoemTypeServiceImpl implements PoemTypeService {
    @Autowired
    PoemTypeMapper poemTypeMapper;


    @Override
    public List<poem_typeDo> listPoem_typeDo() {

        return poemTypeMapper.listPoem_typeDo();

    }
}
