package com.poetry.dao;

import com.poetry.pojo.Do.groupDo;
import com.poetry.pojo.Dto.GreateGroupsDto;

import java.util.List;

public interface GroupMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(groupDo record);

    int insertSelective(groupDo record);

    groupDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(groupDo record);

    int updateByPrimaryKey(groupDo record);


    List<groupDo> listGroupDo();

    List<GreateGroupsDto> listGreateGroupsDtoByCreator_Id(String Creator_id);

    List<groupDo> selectAffiliationGroups(String userId);

    List<groupDo> selectMyFoundingGroups(String userId);

    List<groupDo> selectByKeyWord(String keyWord);

    int getGroupMemberNum(Integer groupId);


}