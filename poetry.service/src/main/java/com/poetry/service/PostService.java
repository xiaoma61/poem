
package com.poetry.service;
import com.github.pagehelper.PageInfo;
import com.poetry.pojo.Do.PostDo;


public interface PostService {
    public static final int POSTS_PAGE_SIZE=6;

    PostDo getPostByPostId(int postId);

    PageInfo<PostDo> getPostsByGroupId(int groupId, int pageNum, int pageSize);

    boolean insertPost(PostDo postDo);


}

