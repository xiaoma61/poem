package com.poetry.service.Impl;

import com.poetry.dao.ReadRecordMapper;
import com.poetry.pojo.Do.read_recordDo;
import com.poetry.pojo.Do.read_record_likeDo;
import com.poetry.service.ReadRecordLikeService;
import com.poetry.service.ReadRecordService;
import com.poetry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReadRecordServiceImpl implements ReadRecordService {
    @Autowired
    ReadRecordMapper readRecordMapper;
    @Autowired
    UserService userService;
    @Autowired
    ReadRecordLikeService readRecordLikeService;

    @Override
    public int insert(read_recordDo record) {
        readRecordMapper.insert(record);
        return 0;
    }
    @Override
    public String register(read_recordDo record, int gold_coin_num) {
        record.setTime(new Date());
        record.setLikesNum(0);
        if (record.getAudioPath().length()<=0){
            return "上传音频失败";
        }

        insert(record);
        userService.updateUserbyid(record.getUeserId(),gold_coin_num);
        return "增加 "+gold_coin_num+" 金币";
    }

    @Override
    public int updateLikeNumsByIdAdd(int id) {
        readRecordMapper.updateLikeNumsByIdAdd(id);
        return 0;
    }

    @Override
    public int updateLikeNumsById(int id) {

        readRecordMapper.updateLikeNumsById(id);
        return 0;
    }

    @Override
    public void setLike(int id, String user_id,int type) {
        readRecordLikeService.deleteByReadRecordIdAndUserId(id,user_id);
        if (type==1){
            //添加
            read_record_likeDo record=new read_record_likeDo();
            record.setReadRecordId(id);
            record.setUserId(user_id);
            readRecordLikeService.insert(record);
            updateLikeNumsByIdAdd(id);
        }else {

            //删除
            updateLikeNumsById(id);
        }


    }


}
