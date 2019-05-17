package com.poetry.web.controller.indexcontroller;

import com.poetry.web.controller.basecontroller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/rank")
public class RankController extends BaseController {


    @Override
    public List doService(int type) {
        return null;
    }
}
