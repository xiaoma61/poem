package com.poetry.service.Impl;

import com.poetry.dao.ReadRecordLikeMapper;
import com.poetry.pojo.Do.read_record_likeDo;
import com.poetry.service.ReadRecordLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author myl
 * @description
 * @date 2019/5/18
 */
@Service
public class ReadRecordLikeServiceImpl implements ReadRecordLikeService {


    @Autowired
    ReadRecordLikeMapper readRecordLikeMapper;

    @Override
    public int deleteByReadRecordIdAndUserId(int read_record_id, String user_id) {

        readRecordLikeMapper.deleteByReadRecordIdAndUserId(read_record_id,user_id);

        return 0;
    }

    @Override
    public int insert(read_record_likeDo record) {
        readRecordLikeMapper.insert(record);
        return 0;
    }
}
