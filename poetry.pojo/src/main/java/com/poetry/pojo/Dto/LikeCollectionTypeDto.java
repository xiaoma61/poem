package com.poetry.pojo.Dto;

/**
 * @author myl
 * @description 诗词点赞和收藏的数量
 * @date 2019/5/23
 */
public class LikeCollectionTypeDto {

    private Integer typeNum;

    private String typeNumName;

    public Integer getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(Integer typeNum) {
        this.typeNum = typeNum;
    }

    public String getTypeNumName() {
        return typeNumName;
    }

    public void setTypeNumName(String typeNumName) {
        this.typeNumName = typeNumName;
    }
}
