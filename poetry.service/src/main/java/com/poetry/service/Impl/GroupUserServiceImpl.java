package com.poetry.service.Impl;

import com.poetry.dao.GroupUserMapper;
import com.poetry.pojo.Do.group_userDo;
import com.poetry.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupUserServiceImpl implements GroupUserService {
    @Autowired
    GroupUserMapper groupUserMapper;

    @Override
    public boolean dropOutGroup(String userId, int groupId) {
        int res=groupUserMapper.deleteByUserIdAndGroupId(groupId,userId);
        if (res==1)return true;
        return false;
    }

    @Override
    public boolean joinGroup(String userId, int groupId) {
        //先检查用户是否已经加入了小组
        if (groupUserMapper.selectByUserIdAndGroupId(groupId,userId)==null){
            group_userDo groupUserDo=new group_userDo();
            groupUserDo.setGroupId(groupId);
            groupUserDo.setUeserId(userId);
            groupUserMapper.insert(groupUserDo);
            return true;
        }
        return false;
    }
}
