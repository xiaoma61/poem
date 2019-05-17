package com.poetry.pojo.Dto;

import com.poetry.pojo.Do.poemDo;

import java.util.List;

/**
 * @author myl
 * @description 诗词内容页面
 * @date 2019/5/17
 */
public class PoemLikeCollectionDto {

    private poemDo poem;

    private List<String>types;

    public poemDo getPoem() {
        return poem;
    }

    public void setPoem(poemDo poem) {
        this.poem = poem;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
