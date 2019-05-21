package com.poetry.service;

import com.github.pagehelper.PageInfo;
import com.poetry.pojo.Do.groupDo;

import java.util.List;

public interface GroupService {

    groupDo selectByPrimaryKey(Integer id);

    List<groupDo> listGroupDo();

     void createGroup(String creatorId, String groupName, String briefIntro,String coverPath);

    PageInfo<groupDo> searchByKeyValue(String keyVal,String userId,int pageNum);

    PageInfo<groupDo> getAffiliationGroups(String userId,int pageNum,int pageSize);

    PageInfo<groupDo> getMyFoundingGroups(String userId,int pageNum,int pageSize);

    boolean DropOutGroup(String userId,int groupId);


}
