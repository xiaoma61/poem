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
     * @description 诗词 诗词内容，是否点赞是否收藏
     * @author myl
     * @date 2019/5/18
     * @param poemid
     * @param id
     * @return [poemid, id]
     */
    @RequestMapping(value = "/{poemid}",method = RequestMethod.GET)
    @ResponseBody
    public R getPoemLikeCollectionDto(@PathVariable("poemid")int poemid,@RequestParam("id")String id){


        return R.ok(poemService.getPoemLikeCollectionDto(id,poemid));
    }


    /**
     * @description 诗词音频
     * @author myl
     * @date 2019/5/18
     * @param id
     * @return [id]
     */
    @RequestMapping(value = "/{poemid}/comment",method = RequestMethod.GET)
    @ResponseBody
    public R getPoemCommentDto(@PathVariable("poemid")int id,@RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "10")int rows,@RequestParam(name = "user_id")String user_id){

        this.poem_id=id;
        this.id=user_id;
        return R.ok(getPageInfo(start,rows,1));
    }



    /**
     * @description 诗词评论上传
     * @author myl
     * @date 2019/5/18
     * @param id
     * @param readRecordCommentDo
     * @return [id, readRecordCommentDo]
     */
    @RequestMapping(value = "/{poemid}/comment",method = RequestMethod.POST)
    @ResponseBody
    public R postPoemComment(@PathVariable("poemid")int id, @RequestBody read_record_commentDo readRecordCommentDo){

        readRecordCommentDo.setTime(new Date());
        readRecordCommentService.insert(readRecordCommentDo);

        return R.ok();
    }


    /**
     * @description 诗词音频上传
     * @author myl
     * @date 2019/5/18
     * @param id
     * @param readRecordDo
     * @return [id, readRecordDo]
     */
    @RequestMapping(value = "/{poemid}/video",method = RequestMethod.POST)
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
    @RequestMapping(value = "/{id}/like",method = RequestMethod.POST)
    @ResponseBody
    public R postPoemLike(@PathVariable("id")int id, @RequestParam("type")int type, @RequestBody likes_collectDo likesCollectDo){



        likesCollectService.like_collect(likesCollectDo,type,true);
        return R.ok();
    }

    /**
     * @description type :1 收藏 2 取消收藏
     * @author myl
     * @date 2019/5/18
     * @param id
     * @param type
     * @return [id, type]
     */
    @RequestMapping(value = "/{id}/collect",method = RequestMethod.POST)
    @ResponseBody
    public R postPoemCollect(@PathVariable("id")int id, @RequestParam("type")int type,@RequestBody likes_collectDo likesCollectDo){
        likesCollectService.like_collect(likesCollectDo,type,false);
        return R.ok();
    }

    /**
     * @description 1 点赞 2 取消点赞,id 为音频id
     * @author myl
     * @date 2019/5/18
     * @param id
     * @param type
     * @return [id, type]
     */
    @RequestMapping(value = "/{id}/video/{videoId}/like",method = RequestMethod.GET)
    @ResponseBody
    public R postPoemVideoLike(@PathVariable("id")int id,@PathVariable("videoId")int videoId, @RequestParam("type")int type,@RequestParam(name = "user_id")String user_id){

        readRecordService.setLike(videoId,user_id,type);
        return R.ok();
    }

    @RequestMapping(value = "/{id}/video/{videoId}/comment",method = RequestMethod.GET)
    @ResponseBody
    // TODO: 2019/5/17 音频的评论
    public R postPoemVideoComment(@PathVariable("id")int id,@PathVariable("videoId")int videoId, @RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "10")int rows){

        video_id=videoId;
        return R.ok(getPageInfo(start,rows,2));
    }

    @Override
    public List doService(int type) {
        if (type==1) {
            return poemService.listPoemReadRecordDtoResultMap(poem_id,id);
        }
        if (type==2){
            return readRecordCommentService.listPoemReadRecordCommentDto(video_id);
        }
        return null;
    }
}
