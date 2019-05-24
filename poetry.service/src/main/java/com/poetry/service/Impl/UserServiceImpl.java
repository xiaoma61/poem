package com.poetry.service.Impl;

import com.poetry.dao.UserMapper;
import com.poetry.pojo.Do.userDo;
import com.poetry.pojo.Dto.PeopleDetailDto;
import com.poetry.pojo.Dto.PeopleDto;
import com.poetry.pojo.Dto.PeopleStatisticsDto;
import com.poetry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public PeopleDto getPeopleDtobyId(String id) {
       return userMapper.getPeopleDtobyId(id);
    }

    @Override
    public PeopleDetailDto getPeopleDetailDto(String id) {
        return userMapper.getPeopleDetailDto(id);
    }

    @Override
    public List<PeopleStatisticsDto> listPeopleStatisticsDto(String id) {
        return userMapper.listPeopleStatisticsDto(id);
    }

    @Override
    public int updateUserbyid(String id, int gold_coin_num) {
        return userMapper.updateUserbyid(id, gold_coin_num);
    }

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
