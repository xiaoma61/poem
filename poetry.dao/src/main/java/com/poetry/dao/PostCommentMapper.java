package com.poetry.dao;

import com.poetry.pojo.Do.post_commentDo;

public interface PostCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(post_commentDo record);

    int insertSelective(post_commentDo record);

    post_commentDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(post_commentDo record);

    int updateByPrimaryKey(post_commentDo record);
}