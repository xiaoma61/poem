package com.poetry.service;

import com.poetry.pojo.Do.groupDo;

import java.util.List;

public interface GroupService {

    groupDo selectByPrimaryKey(Integer id);

    List<groupDo> listGroupDo();

    void craeteGroup(String creatorId,String groupName,String briefIntro,String coverPath);

    List<groupDo> searchByKeyValue(String keyVal);

    List<groupDo> getAffiliationGroups(String userId);

    List<groupDo> getMyFoundingGroups(String userId);



}
