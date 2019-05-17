package com.poetry.web.controller.indexcontroller;


import com.poetry.web.controller.basecontroller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author myl
 * @description小组
 * @date 2019/5/4
 */
@Controller
@RequestMapping("groups")
public class GroupsController extends BaseController {


    @Override
    public List doService(int type) {
        return null;
    }
}
