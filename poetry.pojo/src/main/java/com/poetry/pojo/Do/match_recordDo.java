package com.poetry.pojo.Do;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class match_recordDo {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    private Byte matchScore;

    private String ueserId;

    private Integer matchQuestionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Byte getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(Byte matchScore) {
        this.matchScore = matchScore;
    }

    public String getUeserId() {
        return ueserId;
    }

    public void setUeserId(String ueserId) {
        this.ueserId = ueserId;
    }

    public Integer getMatchQuestionId() {
        return matchQuestionId;
    }

    public void setMatchQuestionId(Integer matchQuestionId) {
        this.matchQuestionId = matchQuestionId;
    }
}