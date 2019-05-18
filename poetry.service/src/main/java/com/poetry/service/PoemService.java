package com.poetry.service;

import com.poetry.commom.R;
import com.poetry.pojo.Dto.*;

import java.util.List;
import java.util.Set;

public interface PoemService {
    /**
     * @description 随机获取古诗
     * @author myl
     * @date 2019/5/14
     * @param
     * @return []
     */
    PeopleRegisterDto getPeopleRegisterDto();

    List<PoemDto> listPoemDto(String q, String type);

    void recordSearch(String q,String  id);

    /**
     * @description 热门搜索
     * @author myl
     * @date 2019/5/16
     * @param
     * @return []
     */
    Set<String> getHotSearch(int type);

    /**
     * @description 最近搜索
     * @author myl
     * @date 2019/5/17
     * @param id
     * @return [id]
     */
    R getRecentSearch(String id);

    /**
     * @description 类型查找
     * @author myl
     * @date 2019/5/17
     * @param id
     * @return [id]
     */
    List<PoemTypeDto> getPoemTypeDto(int id);

    void recordType(Integer type_id,String poemType) ;

    PoemLikeCollectionDto getPoemLikeCollectionDto(String user_id, int poem_id);

    List<PoemReadRecordDto> listPoemReadRecordDtoResultMap(int id);


}
