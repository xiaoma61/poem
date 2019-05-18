package com.poetry.web.controller.poemcontroller;

import com.poetry.commom.R;
import com.poetry.pojo.Do.likes_collectDo;
import com.poetry.pojo.Do.read_recordDo;
import com.poetry.pojo.Do.read_record_commentDo;
import com.poetry.web.controller.basecontroller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author myl
 * @description诗集--诗词评论页面
 * @date 2019/5/17
 */
@Controller
@RequestMapping("/poem")
public class PoemController extends BaseController {


    /**
     * @description 诗词
     * @author myl
     * @date 2019/5/18
     * @param poemid
     * @param id
     * @return [poemid, id]
     */
    @RequestMapping(value = "/{poemid}",method = RequestMethod.GET)
    @ResponseBody
    public R getPoemLikeCollectionDto(@PathVariable("poemid")int poemid,@RequestParam("id")String id){
        //诗词内容，是否点赞是否收藏

        return R.ok(poemService.getPoemLikeCollectionDto(id,poemid));
    }


    /**
     * @description 诗词评论
     * @author myl
     * @date 2019/5/18
     * @param id
     * @return [id]
     */
    // TODO: 2019/5/17 获取诗词读音评论
    @RequestMapping(value = "/{poemid}/comment",method = RequestMethod.GET)
    @ResponseBody
    public R getPoemCommentDto(@PathVariable("poemid")int id,@RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "10")int rows){

        this.poem_id=id;
        return R.ok(getPageInfo(start,rows,1));
    }


    // TODO: 2019/5/17 提交诗词读音评论
    @RequestMapping(value = "/{poemid}/comment",method = RequestMethod.POST)
    @ResponseBody
    public R postPoemComment(@PathVariable("poemid")int id, @RequestBody read_record_commentDo readRecordCommentDo){

        readRecordCommentDo.setTime(new Date());
        readRecordCommentService.insert(readRecordCommentDo);

        return R.ok();
    }

    // TODO: 2019/5/17 诗词音频上传
    @RequestMapping(value = "/{poemid}/video",method = RequestMethod.GET)
    @ResponseBody
    public R getPoemVideo(@PathVariable("poemid")int id,@RequestBody read_recordDo readRecordDo){

        readRecordDo.setTime(new Date());
        readRecordService.insert(readRecordDo);
        return R.ok();
    }


    /**
     * @description type :1 点赞 2 取消点赞
     * @author myl
     * @date 2019/5/18
     * @param id
     * @param type
     * @return [id, type]
     */
   // TODO: 2019/5/17 诗词点赞
    @RequestMapping(value = "/{id}/like_collect",method = RequestMethod.POST)
    @ResponseBody
    public R postPoemLike(@PathVariable("id")int id, @RequestParam("type")int type, @RequestBody likes_collectDo likesCollectDo){



        likesCollectService.like_collect(likesCollectDo,type,true);
        return R.ok();
    }

     // TODO: 2019/5/17 诗词收藏
    @RequestMapping(value = "/{id}/collect",method = RequestMethod.GET)
    @ResponseBody
    public R postPoemCollect(@PathVariable("id")int id, @RequestParam("type")int type,@RequestBody likes_collectDo likesCollectDo){
        likesCollectService.like_collect(likesCollectDo,type,false);
        return R.ok();
    }
    // TODO: 2019/5/17 音频点赞
    /**
     * @description 1 点赞 2 取消点赞,id 为音频id
     * @author myl
     * @date 2019/5/18
     * @param id
     * @param type
     * @return [id, type]
     */
    @RequestMapping(value = "/{id}/video/like",method = RequestMethod.GET)
    @ResponseBody
    public R postPoemVideoLike(@PathVariable("id")int id, @RequestParam("type")int type){


        readRecordService.setLike(id,type);
        return R.ok();
    }

    @Override
    public List doService(int type) {
        if (type==1) {
            return poemService.listPoemReadRecordDtoResultMap(poem_id);
        }
        return null;
    }
}
