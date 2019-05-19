package com.poetry.pojo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author myl
 * @description 音频评论信息列表
 * @date 2019/5/18
 */
public class PoemReadRecordCommentDto {



    private String audioPath;

    private Integer poemId;

    private String ueserId;

    private String avataPath;

    private String userName;

    private Integer id;

    private String commentContent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    private Integer readRecordId;

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
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

    public String getAvataPath() {
        return avataPath;
    }

    public void setAvataPath(String avataPath) {
        this.avataPath = avataPath;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getReadRecordId() {
        return readRecordId;
    }

    public void setReadRecordId(Integer readRecordId) {
        this.readRecordId = readRecordId;
    }
}
