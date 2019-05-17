package com.poetry.web.controller.poemcontroller;

import com.poetry.commom.R;
import com.poetry.web.controller.basecontroller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.poetry.commom.constant.Constants.LIKE;
import static com.poetry.commom.constant.Constants.qHot;


/**
 * @author myl
 * @description 查找模块
 * @date 2019/5/15
 */
@Controller
@RequestMapping("/poem/search")
public class PoemSearchController extends BaseController {



    /**
     * @description 热门查询
     * @author myl
     * @date 2019/5/17
     * @param
     * @return []
     */
    @RequestMapping(value = "/hot",method = RequestMethod.GET)
    @ResponseBody
    public R getHotSearch(){

        return R.ok(poemService.getHotSearch(qHot));

    }

    /**
     * @description 最近查询
     * @author myl
     * @date 2019/5/17
     * @param id
     * @return [id]
     */
    @RequestMapping(value = "/recent",method = RequestMethod.GET)
    @ResponseBody
    public R getRecentSearch(@RequestParam(name = "id")String id){

        return poemService.getRecentSearch(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public R getSearch(@RequestParam(name = "q")String q,@RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "10")int rows,@RequestParam(name = "id")String id){

        this.q=q;
        mtype=LIKE;
        poemService.recordSearch(q, id);
        return R.ok( getPageInfo( start,rows,1 ) );
    }


    @Override
    public List doService(int type) {
        if (type==1){
            return poemService.listPoemDto(q,mtype);
        }
        return null;
    }
}
