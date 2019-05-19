package com.poetry.dao;

import com.poetry.pojo.Do.poemDo;
import com.poetry.pojo.Dto.*;

import java.util.List;

public interface PoemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(poemDo record);

    int insertSelective(poemDo record);

    poemDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(poemDo record);

    int updateByPrimaryKey(poemDo record);

    /**
     * @description 随机获取诗词 签到实现
     * @author myl
     * @date 2019/5/14
     * @param
     * @return []
     */
    PeopleRegisterDto getPeopleRegisterDto();

    /**
     * @description 搜索
     * @author myl
     * @date 2019/5/16
     * @param q
     * @param type
     * @return [q, type]
     */
    List<PoemDto> listPoemDto(String q,String type);

    /**
     * @description 查找类型
     * @author myl
     * @date 2019/5/17
     * @param id
     * @return [id]
     */
    List<PoemTypeDto> getPoemTypeDto(int id);


    /**
     * @description 诗词细节信息
     * @author myl
     * @date 2019/5/18
     * @param user_id
     * @param poem_id
     * @return [user_id, poem_id]
     */
    PoemLikeCollectionDto getPoemLikeCollectionDto(String user_id,int poem_id);

    List<PoemReadRecordDto> listPoemReadRecordDtoResultMap(int id,String user_id);






}