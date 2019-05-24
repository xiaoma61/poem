package com.poetry.web.controller.indexcontroller;

import com.poetry.commom.R;
import com.poetry.pojo.Dto.RankInfoDto;
import com.poetry.web.controller.basecontroller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("index/rank")
public class RankController extends BaseController {

    /**
     * 今日排行榜
     * @return
     */
    @ResponseBody
    @RequestMapping("/get/today")
    public R todayRank(){
        List<RankInfoDto> result=rankService.getOneDayRankings();
        return R.ok(result);
    }

    /**
     * 一周排行榜
     * @return
     */
    @ResponseBody
    @RequestMapping("/get/week")
    public R weekRank(){
        System.out.println("getOneWeekRankings");
        List<RankInfoDto> result=rankService.getOneWeekRankings();
        return R.ok(result);
    }



    @Override
    public List doService(int type) {
        return null;
    }
}
