package com.poetry.pojo.Dto;

/**
 * @author myl
 * @description 个人中心首页信息个人信息
 * @date 2019/5/6
 */
public class PeopleDto {

    private String id;

    private Integer goldCoinNum;

    private Integer experienceVal;

    public Integer getExperienceVal() {
        return experienceVal;
    }

    public void setExperienceVal(Integer experienceVal) {
        this.experienceVal = experienceVal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getGoldCoinNum() {
        return goldCoinNum;
    }

    public void setGoldCoinNum(Integer goldCoinNum) {
        this.goldCoinNum = goldCoinNum;
    }
}
