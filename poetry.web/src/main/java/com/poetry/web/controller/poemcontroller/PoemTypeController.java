package com.poetry.web.controller.poemcontroller;



import com.poetry.commom.R;

import com.poetry.web.controller.basecontroller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static com.poetry.commom.constant.Constants.typeHot;

/**
 * @author myl
 * @description 诗词模块--
 * @date 2019/5/14
 */
@Controller
@RequestMapping("/poem/Type")
public class PoemTypeController extends BaseController {

    /**
     * @description 诗词种类
     * @author myl
     * @date 2019/5/14
     * @param
     * @return []
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public R getType(@RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "10")int rows){

        return R.ok( getPageInfo(start,rows,1));
    }

    /**
     * @description 热门诗词种类
     * @author myl
     * @date 2019/5/14
     * @param
     * @return []
     */
    @RequestMapping(value = "/hot",method = RequestMethod.GET)
    @ResponseBody
    public R getHotType(@RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "10")int rows){

        Set<String> set=poemService.getHotSearch(typeHot);


        return R.ok(set);
    }

    /**
     * @description 诗词列表
     * @author myl
     * @date 2019/5/14
     * @param
     * @return []
     */
    // TODO: 2019/5/17 诗词列表
    @RequestMapping(value = "/{type}",method = RequestMethod.GET)
    @ResponseBody
    public R getType(@RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "10")int rows,@PathVariable("type")int type_id,@RequestParam(name = "poemtype")String poemtype){


        this.type_id=type_id;

        //记录
        poemService.recordType(type_id,poemtype);
        return R.ok( getPageInfo(start,rows,2));
    }




    @Override
    public List doService(int type) {
        if (type==1){
            return poemTypeService.listPoem_typeDo();
        }
        if (type==2){
            return poemService.getPoemTypeDto(type_id);
        }

        return null;

    }
}
