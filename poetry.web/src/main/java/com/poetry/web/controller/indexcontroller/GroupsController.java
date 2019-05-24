package com.poetry.web.controller.indexcontroller;


import com.github.pagehelper.PageInfo;
import com.poetry.commom.R;
import com.poetry.pojo.Do.PostDo;
import com.poetry.pojo.Do.groupDo;
import com.poetry.pojo.Do.post_commentDo;
import com.poetry.pojo.Dto.PostCommentDto;
import com.poetry.service.PostService;
import com.poetry.web.controller.basecontroller.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static com.poetry.commom.constant.Constants.ROW;

/**
 * @author myl
 * @description小组
 * @date 2019/5/4
 */
@Controller
@RequestMapping("index/groups")
public class GroupsController extends BaseController {
    /**
     * 获得加入的小组列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/get/affiliation/{pageNum}")
    public R myAffiliationGroupsList(HttpServletRequest request, @PathVariable int pageNum){
        String userId= (String) request.getAttribute("id");
        PageInfo<groupDo> resultList=groupService.getAffiliationGroups(userId,pageNum,ROW);
        return R.ok(resultList);
    }

    /**
     * 获得创建的小组列表
     */
    @ResponseBody
    @RequestMapping(value = "/get/founding/{pageNum}",method=RequestMethod.GET)
    public R myCreateGroupsList(HttpServletRequest request, @PathVariable int pageNum){
        String userId= (String) request.getAttribute("id");
        PageInfo<groupDo> resultList =groupService.getMyFoundingGroups(userId,pageNum,ROW);
        return R.ok(resultList);
    }

    /**
     * 创建小组
     */
    @ResponseBody
    @RequestMapping(value = "/post/group",method = RequestMethod.POST)
    public R createGroup(HttpServletRequest request, @RequestParam String groupName, @RequestParam String briefIntro,@RequestParam String coverPath){
        String userId=(String)request.getAttribute("id");
        groupService.createGroup(userId,groupName,briefIntro,coverPath);
        return R.ok();
    }

    /**
     * 退出小组
     */
    @ResponseBody
    @RequestMapping(value ="delete/group/{groupId}",method=RequestMethod.GET)
    public R QuitGroup(HttpServletRequest request, @PathVariable int groupId){
        String userId=(String)request.getAttribute("id");
        boolean res=groupUserService.dropOutGroup(userId,groupId);
        if (res)return R.ok();
        return R.error();
    }

    /**
     * 搜索小组
     */
    @ResponseBody
    @RequestMapping(value ="/search",method=RequestMethod.GET)
    public R searchGroups(HttpServletRequest request, @RequestParam("q") String keyWord,  @RequestParam("pageNum") int pageNum){
        String userId=(String)request.getAttribute("id");
        if (StringUtils.isBlank(keyWord)){
            return R.error("字符不能为空");
        }
        PageInfo<groupDo> result=groupService.searchByKeyValue(keyWord,userId,pageNum);
        return R.ok(result);
    }

    /**
     * 帖子详情
     */
    @ResponseBody
    @RequestMapping(value = "/get/{groupId}/posts/{postId}",method=RequestMethod.GET)
    public R postsDetail(@PathVariable int postId, @PathVariable String groupId){
        PostDo res =postService.getPostByPostId(postId);
        return R.ok(res);
    }

    /**
     * 小组帖子列表
     */
    @ResponseBody
    @RequestMapping(value = "/get/{groupId}/postsLst/{pageNum}",method = RequestMethod.GET)
    public R PostList(@PathVariable int groupId, @PathVariable int pageNum){
        PageInfo<PostDo> res=postService.getPostsByGroupId(groupId,pageNum, PostService.POSTS_PAGE_SIZE);
        return R.ok(res);
    }


    /**
     * 发布帖子
     */
    @ResponseBody
    @RequestMapping(value = "/post/{groupId}",method = RequestMethod.POST)
    public R post(HttpServletRequest request, @PathVariable int groupId, @RequestParam String title, @RequestParam String postContent){
        String userId= (String) request.getAttribute("id");
        PostDo postDo=new PostDo();
        postDo.setContent(postContent);
        postDo.setGroupId(groupId);
        postDo.setPosterId(userId);
        postDo.setTitle(title);
        postDo.setPostTime(new Date());
        boolean res=postService.insertPost(postDo);
        if (res)return R.ok();
        return R.error();
    }

    /**
     * 添加评论
     */
    @ResponseBody
    @RequestMapping(value = ("/post/{groupId}/posts/{postId}/comments"),method = RequestMethod.POST)
    public R addComment(HttpServletRequest request, @PathVariable int groupId, @PathVariable int postId, @RequestParam String commentContent){
        String userId= (String) request.getAttribute("id");
        post_commentDo pc=new post_commentDo();
        pc.setCommentContent(commentContent);
        pc.setCommenterId(userId);
        pc.setCommentPostTime(new Date());
        pc.setPostId(postId);
        boolean res=postCommentService.insertComment(pc);
        if (res)return R.ok();
        return R.error();
    }

    /**
     * 评论列表
     */
    @ResponseBody
    @RequestMapping(value = "/get/{groupId}/posts/{postId}/comments/{pageNum}",method = RequestMethod.GET)
    public R postComments(@PathVariable String groupId, @PathVariable int postId, @PathVariable int pageNum){
        PageInfo<PostCommentDto> res=postCommentService.getCommentsByPostId(postId,pageNum, PostService.POSTS_PAGE_SIZE);
        return R.ok(res);
    }

    /**
     * 加入小组
     */
    @ResponseBody
    @RequestMapping(value = "/get/{groupId}",method = RequestMethod.POST)
    public R joinGroup(HttpServletRequest request, @PathVariable int groupId){
        String userId= (String) request.getAttribute("id");
        boolean res=groupUserService.joinGroup(userId,groupId);
        if (res)return R.ok();
        return R.error();
    }

    @Override
    public List doService(int type) {
        return null;
    }
}
