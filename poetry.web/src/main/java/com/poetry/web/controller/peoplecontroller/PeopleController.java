package com.poetry.web.controller.peoplecontroller;

import com.github.pagehelper.PageHelper;
import com.poetry.commom.R;
import com.poetry.commom.constant.Constants;
import com.poetry.pojo.Do.read_recordDo;
import com.poetry.web.controller.basecontroller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.poetry.commom.constant.Constants.COLLECTION;
import static com.poetry.commom.constant.Constants.LIKE;


/**
 * @author myl
 * @description个人中心
 * @date 2019/5/6
 */
@Controller
@RequestMapping("/people")
public class PeopleController extends BaseController {


    /**
     * @description 获取用户的信息
     * @author myl
     * @date 2019/5/6
     * @param
     * @return  R 等级，金币
     */
    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    @ResponseBody()
    public R getPeople(HttpServletRequest request,@PathVariable(value = "Id")String id){

        return R.ok(ueserService.getPeopleDtobyId(id));
    }

    /**
     * @description
     * @author myl
     * @date 2019/5/6
     * @param request
     * @return 个人中心详细信息有 连胜纪录，等级
     */
    @RequestMapping(value = "/{Id}/detail", method = RequestMethod.GET)
    @ResponseBody()
    public R getPeopleById(HttpServletRequest request,@PathVariable(value = "Id")String id){

        return R.ok(ueserService.getPeopleDetailDto(id));
    }

    /**
     * @description
     * @author myl
     * @date 2019/5/7
     * @param request
     * @param start
     * @param rows
     * @param like_collect 1,为点赞 2.为收藏
     * @return [request, start, rows, like_collect]
     */
    @RequestMapping(value = "/{Id}/like_collect/type/{type}",method = RequestMethod.GET)
    @ResponseBody()
    public R getLike_collect(HttpServletRequest request,@RequestParam(name = "start",defaultValue = "0")int start,@RequestParam(name = "rows",defaultValue = "10")int rows,@PathVariable(value = "type")int like_collect,@PathVariable(value = "Id")String id){
        PageHelper.startPage(start,rows);

        String type="";
        if (like_collect==1){
            type=LIKE;

        }else {
            type=COLLECTION;
        }
        this.id=id;
        mtype=type;

        /*List<Likes_CollectionDto>collectionDtos=likesCollectService.listLikes_CollectionDto(id,type);
        PageInfo<Likes_CollectionDto>pageInfo=new PageInfo<>(collectionDtos);*/
        return R.ok( getPageInfo(start,rows,1));
    }

    /**
     * @description 我创建的小组
     * @author myl
     * @date 2019/5/8
     * @param request
     * @param start
     * @param rows
     * @return [request, start, rows]
     */
    @RequestMapping(value = "/{Id}/creategroup",method = RequestMethod.GET)
    @ResponseBody()
    public R getCreateGroup(HttpServletRequest request,@RequestParam(name = "start",defaultValue = "0")int start,@RequestParam(name = "rows",defaultValue = "10")int rows,@PathVariable(value = "Id")String id){
        PageHelper.startPage(start,rows);
       /* String Creator_Id=id;*/
        this.id=id;
       /* List<GreateGroupsDto>collectionDtos=groupService.listGreateGroupsDtoByCreator_Id(Creator_Id);
        PageInfo<GreateGroupsDto>pageInfo=new PageInfo<>(collectionDtos);*/
        return R.ok( getPageInfo(start,rows,2));
    }

    /**
     * @description 获取我的统计信息，七天的朗诵数据，和一天的频率
     * @author myl
     * @date 2019/5/8
     * @param request
     * @return [request, start, rows]
     */
    @RequestMapping(value = "/{Id}/statistics",method = RequestMethod.GET)
    @ResponseBody()
    public R getStatistics(HttpServletRequest request,@PathVariable(value = "Id")String id){

        return R.ok(ueserService.listPeopleStatisticsDto(id));
    }


    /**
     * @description 签到
     * @author myl
     * @date 2019/5/14
     * @param request
     * @param id
     * @param readRecordDo
     * @return [request, id, readRecordDo]
     */
    @RequestMapping(value = "/{Id}/register",method = RequestMethod.POST)
    @ResponseBody()
    public R postRegister(HttpServletRequest request, @PathVariable(value = "Id")String id, @RequestBody read_recordDo readRecordDo){
        //更新个人信息的金币数和等级
        return R.ok(readRecordService.register(readRecordDo, Constants.GOLD_COIN_NUM_REGISTER));
    }



    /**
     * @description 随机获取诗集
     * @author myl
     * @date 2019/5/14
     * @param request
     * @param id
     * @return [request, id]
     */
    @RequestMapping(value = "/{Id}/register",method = RequestMethod.GET)
    @ResponseBody()
    public R getRegister(HttpServletRequest request, @PathVariable(value = "Id")String id){
        //更新个人信息的金币数和等级
        return R.ok(poemService.getPeopleRegisterDto());
    }


    @Override
    public List doService(int type) {
        if (type==1){
            return likesCollectService.listLikes_CollectionDto(id,mtype);
        }
        if (type==2){
            return groupService.listGreateGroupsDtoByCreator_Id(id);
        }
        return null;
    }
}
