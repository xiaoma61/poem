package com.poetry.service;

import com.poetry.pojo.Do.read_recordDo;

public interface ReadRecordService {

    /**
     * @description 插入朗读信息
     * @author myl
     * @date 2019/5/12
     * @param record
     * @return [record]
     */
    int insert(read_recordDo record);
    /**
     * @description 插入朗读信息和更新金币数目 签到
     * @author myl
     * @date 2019/5/12
     * @param record
     * @return [record]
     */
    String register(read_recordDo record, int gold_coin_num);

    int updateLikeNumsByIdAdd(int id);

    int  updateLikeNumsById(int id);

    void setLike(int id,int type);

}
