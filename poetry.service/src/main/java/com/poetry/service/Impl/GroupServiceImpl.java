package com.poetry.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.poetry.dao.GroupMapper;
import com.poetry.dao.GroupUserMapper;
import com.poetry.pojo.Do.groupDo;
import com.poetry.pojo.Do.group_userDo;
import com.poetry.pojo.Dto.GreateGroupsDto;
import com.poetry.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    public static final int PAGE_SIZE=6;

    @Autowired
    GroupMapper groupMapper;
    @Autowired
    GroupUserMapper groupUserMapper;


    @Override
    public groupDo selectByPrimaryKey(Integer id) {
        return groupMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<groupDo> listGroupDo() {
        return groupMapper.listGroupDo();
    }

    @Override
    public List<GreateGroupsDto> listGreateGroupsDtoByCreator_Id(String Creator_id) {
        return groupMapper.listGreateGroupsDtoByCreator_Id(Creator_id);
    }


    @Override

    public void createGroup(String creatorId, String groupName, String briefIntro,String coverPath) {
        groupDo groupDo=new groupDo();
        groupDo.setName(groupName);
        groupDo.setCreateTime(new Date());
        groupDo.setGroupIntro(briefIntro);
        groupDo.setCoverPath(coverPath);
        groupDo.setCreatorId(creatorId);
        groupMapper.insert(groupDo);
    }

    @Override
    public PageInfo<groupDo> searchByKeyValue(String keyVal, String userId, int pageNum) {
        System.out.println("key::"+keyVal);
        PageHelper.startPage(pageNum,PAGE_SIZE);
        PageInfo<groupDo> pageInfo=new PageInfo<>(groupMapper.selectByKeyWord("%"+keyVal+"%"));
        for (com.poetry.pojo.Do.groupDo groupDo:pageInfo.getList()){
            if (groupUserMapper.selectByUserIdAndGroupId(groupDo.getId(),userId)!=null){
                groupDo.setJoined(true);
            }
            groupDo.setJoined(false);
        }
        return pageInfo;
    }

    @Override
    public PageInfo<groupDo> getAffiliationGroups(String userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<groupDo> pageInfo=new PageInfo<>(groupMapper.selectAffiliationGroups(userId));
        for (groupDo group:pageInfo.getList()){
            group.setGroupMemberNum(groupMapper.getGroupMemberNum(group.getId()));
            group.setJoined(true);
        }
        return pageInfo;
    }

    @Override
    public PageInfo<groupDo> getMyFoundingGroups(String userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<groupDo> pageInfo=new PageInfo<>(groupMapper.selectMyFoundingGroups(userId));
        for (groupDo group:pageInfo.getList()){
            group.setGroupMemberNum(groupMapper.getGroupMemberNum(group.getId()));
            group.setJoined(true);
        }
        return pageInfo;
    }

    @Override
    public boolean DropOutGroup(String userId, int groupId) {
        group_userDo gu=new group_userDo();
        gu.setGroupId(groupId);
        gu.setUeserId(userId);
        int res=groupUserMapper.deleteByUserIdAndGroupId(groupId,userId);
        if (res==1)return true;
        return false;

    }
}
