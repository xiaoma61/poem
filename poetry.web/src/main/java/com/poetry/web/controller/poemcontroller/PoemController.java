package com.poetry.web.controller.poemcontroller;

import com.poetry.commom.R;
import com.poetry.commom.RedisUtil;
import com.poetry.web.controller.basecontroller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@Controller
@RequestMapping("index/poem")
public class PoemController extends BaseController {

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
    public R postPoemVideoLike(@PathVariable("id")int id, @PathVariable("videoId")int videoId, @RequestParam("type")int type, @RequestParam(name = "user_id")String user_id){

        //readRecordService.setLike(videoId,user_id,type);
        rankService.addLike(videoId);
        return R.ok();
    }
}
