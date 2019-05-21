package com.poetry.dao;

import com.poetry.pojo.Do.PostDo;
import com.poetry.pojo.Do.userDo;
import javafx.geometry.Pos;

import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostDo record);

    int insertSelective(PostDo record);

    PostDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostDo record);

    int updateByPrimaryKey(PostDo record);

    List<PostDo> selectByGroupId(int groupId);



}