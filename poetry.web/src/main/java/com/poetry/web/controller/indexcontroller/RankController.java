package com.poetry.web.controller.indexcontroller;

import com.poetry.commom.R;
import com.poetry.web.controller.basecontroller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("index/rank")
public class RankController extends BaseController {

    @ResponseBody
    @RequestMapping("/today")
    public R todayRank(){
        return R.error();
    }

    @ResponseBody
    @RequestMapping("/week")
    public R weekRank(){
        return R.ok();
    }






}
