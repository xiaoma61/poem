package com.poetry.pojo.Do;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class read_record_commentDo {
    private Integer id;

    private String commentContent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    private Integer ueserId;

    private Integer readRecordId;

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
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUeserId() {
        return ueserId;
    }

    public void setUeserId(Integer ueserId) {
        this.ueserId = ueserId;
    }

    public Integer getReadRecordId() {
        return readRecordId;
    }

    public void setReadRecordId(Integer readRecordId) {
        this.readRecordId = readRecordId;
    }
}