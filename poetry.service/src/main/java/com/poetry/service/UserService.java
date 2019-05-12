package com.poetry.service;

import com.poetry.pojo.Dto.PeopleDetailDto;
import com.poetry.pojo.Dto.PeopleDto;
import com.poetry.pojo.Dto.PeopleStatisticsDto;

import java.util.List;

public interface UserService {

    /**
     * @description 个人中心首页信息
     * @author myl
     * @date 2019/5/12
     * @param id
     * @return [id]
     */
    PeopleDto getPeopleDtobyId(String id);

    /**
     * @description 个人中心细节信息 连胜纪录
     * @author myl
     * @date 2019/5/12
     * @param id
     * @return [id]
     */
    PeopleDetailDto getPeopleDetailDto(String id);
    /**
     * @description 个人中心查询七天内数据
     * @author myl
     * @date 2019/5/12
     * @param id
     * @return [id]
     */
    List<PeopleStatisticsDto> listPeopleStatisticsDto(String id);

    /**
     * @description 更新金币
     * @author myl
     * @date 2019/5/12
     * @param id
     * @param gold_coin_num
     * @return [id, gold_coin_num]
     */
    int updateUserbyid(String id,int gold_coin_num);
}
