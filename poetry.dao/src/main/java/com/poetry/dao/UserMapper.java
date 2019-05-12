package com.poetry.dao;

import com.poetry.pojo.Do.userDo;
import com.poetry.pojo.Dto.PeopleDetailDto;
import com.poetry.pojo.Dto.PeopleDto;
import com.poetry.pojo.Dto.PeopleStatisticsDto;

import java.util.List;


public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(userDo record);

    int insertSelective(userDo record);

    userDo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(userDo record);

    int updateByPrimaryKey(userDo record);

    PeopleDto getPeopleDtobyId(String id);

    PeopleDetailDto getPeopleDetailDto(String id);

    List<PeopleStatisticsDto> listPeopleStatisticsDto(String id);

    int updateUserbyid(String id,int gold_coin_num);


}