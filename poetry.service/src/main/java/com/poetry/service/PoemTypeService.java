package com.poetry.service;

import com.poetry.pojo.Do.poem_typeDo;

import java.util.List;

public interface PoemTypeService {

    /**
     * @description 获取诗词类型列表
     * @author myl
     * @date 2019/5/14
     * @param
     * @return []
     */
    List<poem_typeDo> listPoem_typeDo();

}
