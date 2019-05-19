package com.poetry.web.controller.indexcontroller;


import com.poetry.commom.R;
import com.poetry.pojo.Do.groupDo;
import com.poetry.web.controller.basecontroller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("index/groups")
public class GroupsController extends BaseController {
    /**
     * 获得加入的小组列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/get/affiliation")
    public R myAffiliationGroupsList(HttpServletRequest request){
        String userId= (String) request.getAttribute("id");
        System.out.println("GroupsController"+userId);
        List<groupDo> resultList=groupService.getAffiliationGroups(userId);
        return R.ok(resultList);
    }

    /**
     * 获得创建的小组列表
     */
    @ResponseBody
    @RequestMapping(value = "/get/founding",method=RequestMethod.GET)
    public R myCreateGroupsList(HttpServletRequest request){
        String userId= (String) request.getAttribute("id");
        List<groupDo> resultList =groupService.getMyFoundingGroups(userId);
        return R.ok(resultList);
    }

    /**
     * 创建小组
     */
    @ResponseBody
    @RequestMapping(value = "/post/group",method = RequestMethod.POST)
    public R createGroup(HttpServletRequest request,@RequestParam String groupName,@RequestParam String briefIntro){
        String userId=(String)request.getAttribute("id");
        groupService.craeteGroup(userId,groupName,briefIntro,"");
        return R.ok();
    }

    /**
     * 退出小组
     */
    @ResponseBody
    @RequestMapping(value ="delete/groupsId",method=RequestMethod.GET)
    public R QuitGroup(){
        return R.ok();
    }

    /**
     * 搜索小组
     */
    @ResponseBody
    @RequestMapping(value ="/q/{keyValue}",method=RequestMethod.GET)
    public R searchGroups(@PathVariable String keyValue){

        return R.ok();
    }

    /**
     * 帖子详情
     */
    @ResponseBody
    @RequestMapping(value = "/get/{groupId}/posts/{postId",method=RequestMethod.GET)
    public R postsDetail(@PathVariable int postId, @PathVariable String groupId){
        return R.ok();
    }

    /**
     * 小组帖子列表
     */
    @ResponseBody
    @RequestMapping(value = "/get/{groupId}/postsLst",method = RequestMethod.GET)
    public R PostList(@PathVariable String groupId){
return R.ok();
    }

    /**
     * 帖子详情
     */
    @ResponseBody
    @RequestMapping(value = "/get/{groupId}/posts/{postId}",method = RequestMethod.GET)
    public R postDetail(@PathVariable int postId,@PathVariable int groupId){
        return R.ok();
    }

    /**
     * 发布帖子
     */
    @ResponseBody
    @RequestMapping(value = "/post/{groupId}",method = RequestMethod.POST)
    public R post(@PathVariable String groupId){
        return R.ok();
    }

    /**
     * 添加评论
     */
    @ResponseBody
    @RequestMapping(value = ("/post/{groupId}/posts/{postId}/comments"),method = RequestMethod.POST)
    public R addComment(HttpServletRequest request,@PathVariable String groupId, @PathVariable String postId,@RequestParam String commentContent){
        String userId= (String) request.getAttribute("id");
        return R.ok();
    }

    /**
     * 评论列表
     */
    @ResponseBody
    @RequestMapping(value = "/get/{groupId}/posts/{postId}/comments",method = RequestMethod.GET)
    public R postComments(@PathVariable String groupId, @PathVariable String postId){
return R.ok();
    }

}
