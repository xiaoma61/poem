package com.poetry.service;

import com.poetry.pojo.Do.groupDo;

import java.util.List;

public interface GroupService {
    groupDo selectByPrimaryKey(Integer id);
    List<groupDo> listGroupDo();
}
