package com.poetry.service.Impl;


import com.poetry.dao.GroupMapper;

import com.poetry.pojo.Do.groupDo;
import com.poetry.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupMapper groupMapper;

    @Override
    public groupDo selectByPrimaryKey(Integer id) {
        return groupMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<groupDo> listGroupDo() {
        return groupMapper.listGroupDo();
    }
}
