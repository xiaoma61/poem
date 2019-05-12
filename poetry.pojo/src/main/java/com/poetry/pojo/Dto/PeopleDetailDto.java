package com.poetry.pojo.Dto;

/**
 * @author myl
 * @description 个人中心用户详细个人信息
 * @date 2019/5/6
 */
public class PeopleDetailDto {
    private String id;

    private Integer experienceVal;

    private Integer goldCoinNum;

    private Long gameWinningstreak;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Integer getExperienceVal() {
        return experienceVal;
    }

    public void setExperienceVal(Integer experienceVal) {
        this.experienceVal = experienceVal;
    }

    public Integer getGoldCoinNum() {
        return goldCoinNum;
    }

    public void setGoldCoinNum(Integer goldCoinNum) {
        this.goldCoinNum = goldCoinNum;
    }

    public Long getGameWinningstreak() {
        return gameWinningstreak;
    }

    public void setGameWinningstreak(Long gameWinningstreak) {
        this.gameWinningstreak = gameWinningstreak;
    }
}
