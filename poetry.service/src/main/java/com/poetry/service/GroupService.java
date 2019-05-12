package com.poetry.service;

import com.poetry.pojo.Do.groupDo;
import com.poetry.pojo.Dto.GreateGroupsDto;

import java.util.List;

public interface GroupService {
    groupDo selectByPrimaryKey(Integer id);

    List<groupDo> listGroupDo();

    List<GreateGroupsDto> listGreateGroupsDtoByCreator_Id(String Creator_id);
}
