package com.poetry.pojo.Do;

import java.util.Date;

public class match_result extends match_resultKey {
    private Long gameWinningstreak;

    private Date time;

    public Long getGameWinningstreak() {
        return gameWinningstreak;
    }

    public void setGameWinningstreak(Long gameWinningstreak) {
        this.gameWinningstreak = gameWinningstreak;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}