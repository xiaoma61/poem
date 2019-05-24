package com.poetry.dao;

import com.poetry.pojo.Do.group_userDo;
import org.apache.ibatis.annotations.Param;

public interface GroupUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(group_userDo record);

    int insertSelective(group_userDo record);

    group_userDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(group_userDo record);

    int updateByPrimaryKey(group_userDo record);

    int deleteByUserIdAndGroupId(@Param(value = "groupId")Integer groupId, @Param(value = "userId") String userId);

    group_userDo selectByUserIdAndGroupId(@Param(value = "groupId")Integer groupId,@Param(value = "userId") String userId);

}