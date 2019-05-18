package com.poetry.web.controller.basecontroller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.poetry.dao.redis.RedisUtil;
import com.poetry.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public abstract class  BaseController <T>{
    @Autowired
    protected
    GroupService groupService;
    @Autowired
    protected GroupUserService groupUserService;
    @Autowired
    protected LikesCollectService likesCollectService;
    @Autowired
    protected MatchQuestionService matchQuestionService;
    @Autowired
    protected PoemPoemTypeService poemPoemTypeService;
    @Autowired
    protected PoemService poemService;
    @Autowired
    protected PoemTypeService poemTypeService;
    @Autowired
    protected PostCommentService postCommentService;
    @Autowired
    protected ReadRecordCommentService readRecordCommentService;
    @Autowired
    protected ReadRecordService readRecordService;
    @Autowired
    protected UserService ueserService;



    protected  String q="";
    protected  String mtype="";
    protected int type_id=0;
    protected String id="";
    protected int poem_id=0;




    public String  getOpenId(HttpServletRequest request){
        HttpSession session=request.getSession();
        String id= (String) session.getAttribute("openid");
        return "1";
    }

    public  PageInfo<T> pageInfo;
    public  List<T> list;
    public final  PageInfo<T>  getPageInfo(int start,int rows,int type){
        PageHelper.startPage(start, rows);
        list=doService(type);
        pageInfo= new PageInfo<>(list);
        return pageInfo;
    }
    public abstract List<T> doService(int type);




}
