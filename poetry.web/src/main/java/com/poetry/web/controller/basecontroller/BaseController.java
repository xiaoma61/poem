package com.poetry.web.controller.basecontroller;

import com.poetry.service.*;
import com.poetry.service.Impl.WXServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public abstract class  BaseController {
    @Autowired
    public GroupService groupService;
    @Autowired
    public GroupUserService groupUserService;
    @Autowired
    public LikesCollectService likesCollectService;
    @Autowired
    public MatchQuestionService matchQuestionService;
    @Autowired
    public PoemPoemTypeService poemPoemTypeService;
    @Autowired
    public PoemService poemService;
    @Autowired
    public PoemTypeService poemTypeService;
    @Autowired
    public PostCommentService postCommentService;
    @Autowired
    public ReadRecordCommentService readRecordCommentService;
    @Autowired
    public ReadRecordService readRecordService;
    @Autowired
    public UserService userService;
    @Autowired
    public WXService wxService;
    @Autowired
    public PostService postService;




}
