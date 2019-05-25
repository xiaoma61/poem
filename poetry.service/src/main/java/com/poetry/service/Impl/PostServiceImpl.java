package com.poetry.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.poetry.dao.PostCommentMapper;
import com.poetry.dao.PostMapper;
import com.poetry.dao.UserMapper;
import com.poetry.pojo.Do.PostDo;
import com.poetry.pojo.Do.userDo;
import com.poetry.pojo.Dto.PostCommentDto;
import com.poetry.service.PostCommentService;
import com.poetry.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PostCommentMapper postCommentMapper;

    @Override
    public PostDo getPostByPostId(int postId) {
        return postMapper.selectByPrimaryKey(postId);
    }

    @Override
    public PageInfo<PostDo> getPostsByGroupId(int groupId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<PostDo> pageInfo=new PageInfo<>(postMapper.selectByGroupId(groupId));
        for ( PostDo post:pageInfo.getList()){
            int commentsNum=postCommentMapper.getCommentsNumByPostId(post.getId());
            post.setReliesNum(commentsNum);
            userDo user=userMapper.selectByPrimaryKey(post.getPosterId());
            post.setPoster(user.getUserName());
            post.setPosterAvatar(user.getAvataPath());
            post.setPosterId(null);


        }
        return pageInfo;
    }

    @Override
    public boolean insertPost(PostDo postDo) {
        int res=postMapper.insert(postDo);
        if (res==1)return true;
        return false;
    }
}
