package com.poetry.dao;

import com.poetry.pojo.Do.read_recordDo;
import com.poetry.pojo.Dto.RankInfoDto;

public interface ReadRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(read_recordDo record);

    int insertSelective(read_recordDo record);

    read_recordDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(read_recordDo record);

    /**
     * @description 更新增加
     * @author myl
     * @date 2019/5/18
     * @param id
     * @return [id]
     */
    int updateLikeNumsByIdAdd(int id);
    /**
     * @description 更新减少
     * @author myl
     * @date 2019/5/18
     * @param id
     * @return [id]
     */
    int  updateLikeNumsById(int id);

    RankInfoDto selectRankInfoById(Integer id);

}