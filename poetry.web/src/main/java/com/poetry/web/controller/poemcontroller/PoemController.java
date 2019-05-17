package com.poetry.web.controller.poemcontroller;

import com.poetry.commom.R;
import com.poetry.web.controller.basecontroller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author myl
 * @description诗集--诗词评论页面
 * @date 2019/5/17
 */
@Controller
@RequestMapping("/poem")
public class PoemController extends BaseController {

    // TODO: 2019/5/17 诗词
    @RequestMapping(name = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public R getPoem(@PathVariable("id")int id){
        //诗词内容，是否点赞是否收藏
        return R.ok();
    }

    // TODO: 2019/5/17 诗词评论
    @RequestMapping(name = "/{id}/comment",method = RequestMethod.GET)
    @ResponseBody
    public R getPoemComment(@PathVariable("id")int id){
        //诗词内容，是否点赞是否收藏
        return R.ok();
    }
    // TODO: 2019/5/17 提交诗词评论
    @RequestMapping(name = "/{id}/comment",method = RequestMethod.POST)
    @ResponseBody
    public R postPoemComment(@PathVariable("id")int id){
        //诗词内容，是否点赞是否收藏
        return R.ok();
    }

    // TODO: 2019/5/17 诗词音频
    @RequestMapping(name = "/{id}/comment",method = RequestMethod.GET)
    @ResponseBody
    public R getPoemVideo(@PathVariable("id")int id){
        //诗词内容，是否点赞是否收藏
        return R.ok();
    }


    // TODO: 2019/5/17 诗词点赞
    @RequestMapping(name = "/{id}/like_collect",method = RequestMethod.POST)
    @ResponseBody
    public R postPoemLike(@PathVariable("id")int id, @RequestParam("type")int type){
        //诗词内容，是否点赞是否收藏
        return R.ok();
    }

    // TODO: 2019/5/17 诗词收藏
    @RequestMapping(name = "/{id}/collect",method = RequestMethod.GET)
    @ResponseBody
    public R postPoemCollect(@PathVariable("id")int id, @RequestParam("type")int type){
        //诗词内容，是否点赞是否收藏
        return R.ok();
    }
    // TODO: 2019/5/17 音频点赞
    @RequestMapping(name = "/{id}/video/collect",method = RequestMethod.GET)
    @ResponseBody
    public R postPoemVideoLike(@PathVariable("id")int id, @RequestParam("type")int type){
        //诗词内容，是否点赞是否收藏
        return R.ok();
    }

    @Override
    public List doService(int type) {
        return null;
    }
}
