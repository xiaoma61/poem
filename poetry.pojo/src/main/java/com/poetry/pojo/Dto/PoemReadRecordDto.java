package com.poetry.pojo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author myl
 * @description 诗词朗读信息
 * @date 2019/5/18
 */
public class PoemReadRecordDto {

    private Integer id;

    private String audioPath;

    private Integer likesNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    private Integer poemId;

    private String ueserId;

    private String avataPath;

    private String userName;

    private Integer read_record_commentNum;

    public Integer getRead_record_commentNum() {
        return read_record_commentNum;
    }

    public void setRead_record_commentNum(Integer read_record_commentNum) {
        this.read_record_commentNum = read_record_commentNum;
    }

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
        this.audioPath = audioPath;
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
}
