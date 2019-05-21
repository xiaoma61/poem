package com.poetry.dao;

import com.poetry.pojo.Do.post_commentDo;
import com.poetry.pojo.Dto.PostCommentDto;

import java.util.List;

public interface PostCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(post_commentDo record);

    int insertSelective(post_commentDo record);

    post_commentDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(post_commentDo record);

    int updateByPrimaryKey(post_commentDo record);

    List<PostCommentDto> selectByPostId(int postId);

    int getCommentsNumByPostId(int postId);
}