package com.poetry.service.Impl;


import com.poetry.dao.GroupMapper;

import com.poetry.pojo.Do.groupDo;
import com.poetry.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public void craeteGroup(String creatorId, String groupName, String briefIntro,String coverPath) {
        groupDo groupDo=new groupDo();
        groupDo.setName(groupName);
        groupDo.setCreateTime(new Date());
        groupDo.setGroupIntro(briefIntro);
        groupDo.setCoverPath(coverPath);
        groupDo.setCreatorId(creatorId);
        groupMapper.insert(groupDo);
    }

    @Override
    public List<groupDo> searchByKeyValue(String keyVal) {
        return null;
    }

    @Override
    public List<groupDo> getAffiliationGroups(String userId) {

        return null;
    }

    @Override
    public List<groupDo> getMyFoundingGroups(String userId) {
        return null;
    }
}
