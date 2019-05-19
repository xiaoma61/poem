package com.poetry.service;

import com.poetry.pojo.Do.read_record_likeDo;

public interface ReadRecordLikeService {

    int deleteByReadRecordIdAndUserId(int read_record_id,String user_id);

    int insert(read_record_likeDo record);
}
