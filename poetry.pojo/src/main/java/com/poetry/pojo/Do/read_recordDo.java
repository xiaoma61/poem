package com.poetry.pojo.Do;

import java.util.Date;

public class read_recordDo {
    private Integer id;

    private String audioPath;

    private Integer likesNum;

    private Date time;

    private Integer poemId;

    private Integer ueserId;

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

    public Integer getUeserId() {
        return ueserId;
    }

    public void setUeserId(Integer ueserId) {
        this.ueserId = ueserId;
    }
}