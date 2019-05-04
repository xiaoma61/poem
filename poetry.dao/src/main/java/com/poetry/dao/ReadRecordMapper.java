package com.poetry.dao;

import com.poetry.pojo.Do.read_recordDo;

public interface ReadRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(read_recordDo record);

    int insertSelective(read_recordDo record);

    read_recordDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(read_recordDo record);

    int updateByPrimaryKey(read_recordDo record);
}