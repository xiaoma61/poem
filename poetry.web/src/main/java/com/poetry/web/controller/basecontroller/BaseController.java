package com.poetry.web.controller.basecontroller;

import com.poetry.service.*;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class  BaseController {
    @Autowired
    protected
    GroupService groupService;
    @Autowired
    GroupUserService groupUserService;
    @Autowired
    LikesCollectService likesCollectService;
    @Autowired
    MatchQuestionService matchQuestionService;
    @Autowired
    PoemPoemTypeService poemPoemTypeService;
    @Autowired
    PoemService poemService;
    @Autowired
    PoemTypeService poemTypeService;
    @Autowired
    PostCommentService postCommentService;
    @Autowired
    ReadRecordCommentService readRecordCommentService;
    @Autowired
    ReadRecordService readRecordService;
    @Autowired
    UserService ueserService;




}
