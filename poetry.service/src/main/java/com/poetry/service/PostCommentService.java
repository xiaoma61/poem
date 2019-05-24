package com.poetry.service;

import com.github.pagehelper.PageInfo;
import com.poetry.pojo.Do.post_commentDo;
import com.poetry.pojo.Dto.PostCommentDto;

public interface PostCommentService {

    public static final int POST_COMMENTS_PAGE_SIZE=6;

    boolean insertComment(post_commentDo postCommentDo);

    PageInfo<PostCommentDto> getCommentsByPostId(int postId, int pageNum, int pageSize);
}
