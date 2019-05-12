package com.poetry.web.controller.basecontroller;

import com.poetry.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class  BaseController {
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

    public String  getOpenId(HttpServletRequest request){
        HttpSession session=request.getSession();
        String id= (String) session.getAttribute("openid");
        return "1";
    }




}
