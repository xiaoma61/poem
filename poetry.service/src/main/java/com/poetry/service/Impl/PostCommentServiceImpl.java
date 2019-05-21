package com.poetry.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.poetry.dao.PostCommentMapper;
import com.poetry.dao.UserMapper;
import com.poetry.pojo.Do.post_commentDo;
import com.poetry.pojo.Do.userDo;
import com.poetry.pojo.Dto.PostCommentDto;
import com.poetry.service.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentServiceImpl implements PostCommentService {

    @Autowired
    PostCommentMapper postCommentMapper;

    @Override
    public boolean insertComment(post_commentDo postCommentDo) {
        int res=postCommentMapper.insert(postCommentDo);
        if (res==1)return true;
        return false;
    }

    @Override
    public PageInfo<PostCommentDto> getCommentsByPostId(int postId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<PostCommentDto> pageInfo=new PageInfo<PostCommentDto>(postCommentMapper.selectByPostId(postId));
        return pageInfo;
    }
}
