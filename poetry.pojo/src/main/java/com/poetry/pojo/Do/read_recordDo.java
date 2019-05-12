package com.poetry.pojo.Do;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class read_recordDo {
    private Integer id;

    private String audioPath;

    private Integer likesNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    private Integer poemId;

    private String ueserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath == null ? null : audioPath.trim();
    }

    public Integer getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(Integer likesNum) {
        this.likesNum = likesNum;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getPoemId() {
        return poemId;
    }

    public void setPoemId(Integer poemId) {
        this.poemId = poemId;
    }

    public String getUeserId() {
        return ueserId;
    }

    public void setUeserId(String ueserId) {
        this.ueserId = ueserId;
    }
}