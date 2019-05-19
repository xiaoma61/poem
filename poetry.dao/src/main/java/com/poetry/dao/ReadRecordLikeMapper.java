package com.poetry.dao;

import com.poetry.pojo.Do.read_record_likeDo;

public interface ReadRecordLikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(read_record_likeDo record);

    int insertSelective(read_record_likeDo record);

    read_record_likeDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(read_record_likeDo record);

    int updateByPrimaryKey(read_record_likeDo record);

    int deleteByReadRecordIdAndUserId(int read_record_id,String user_id);
}