package com.poetry.web.controller.poemcontroller;

import com.poetry.commom.R;
import com.poetry.pojo.Do.likes_collectDo;
import com.poetry.pojo.Do.read_recordDo;
import com.poetry.pojo.Do.read_record_commentDo;
import com.poetry.web.controller.basecontroller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author myl
 * @description 诗集--诗词评论页面
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
     * @return [poemid, id]
     */
    @RequestMapping(value = "/{poemid}",method = RequestMethod.GET)
    @ResponseBody
    public R getPoemLikeCollectionDto(HttpServletRequest request,@PathVariable("poemid")int poemid){



        return R.ok(poemService.getPoemLikeCollectionDto(getOpenId(request),poemid));
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
    public R getPoemCommentDto(HttpServletRequest request,@PathVariable("poemid")int id,@RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "10")int rows){

        this.poem_id=id;
        this.id=getOpenId(request);
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
    public R postPoemComment(@PathVariable("poemid")int id, @RequestBody read_record_commentDo readRecordCommentDo,HttpServletRequest request){

        readRecordCommentDo.setTime(new Date());
        readRecordCommentDo.setUeserId(getOpenId(request));
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
    public R getPoemVideo(@PathVariable("poemid")int id,@RequestBody read_recordDo readRecordDo,HttpServletRequest request){

        readRecordDo.setTime(new Date());
        readRecordDo.setUeserId(getOpenId(request));
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
    public R postPoemLike(@PathVariable("id")int id, @RequestParam("type")int type, @RequestBody likes_collectDo likesCollectDo,HttpServletRequest request){

        likesCollectDo.setUeserId(getOpenId(request));
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
    public R postPoemCollect(@PathVariable("id")int id, @RequestParam("type")int type,@RequestBody likes_collectDo likesCollectDo,HttpServletRequest request){
        likesCollectDo.setUeserId(getOpenId(request));
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
    public R postPoemVideoLike(@PathVariable("id")int id,@PathVariable("videoId")int videoId, @RequestParam("type")int type,HttpServletRequest request){
        rankService.addLike(videoId);
        readRecordService.setLike(videoId,getOpenId(request),type);
        return R.ok();
    }

    /**
     * @description    音频的评论
     * @author myl
     * @date 2019/5/24
     * @param id
     * @param videoId
     * @param start
     * @param rows
     * @return [id, videoId, start, rows]
     */
    @RequestMapping(value = "/{id}/video/{videoId}/comment",method = RequestMethod.GET)
    @ResponseBody

    public R postPoemVideoComment(@PathVariable("id")int id,@PathVariable("videoId")int videoId, @RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "10")int rows){

        rankService.addComment(videoId);
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
