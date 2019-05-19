package com.poetry.service.Impl;

import com.poetry.dao.UserMapper;
import com.poetry.pojo.Do.userDo;
import com.poetry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public userDo findUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean insertUser(userDo user) {
        int result=userMapper.insert(user);
        if (result==1)return true;
        return false;
    }

    @Override
    public boolean updateUserInfo(userDo userDo) {
        int res=userMapper.updateByPrimaryKeySelective(userDo);
        if (res==1){
            return true;
        }
        return false;
    }
}
