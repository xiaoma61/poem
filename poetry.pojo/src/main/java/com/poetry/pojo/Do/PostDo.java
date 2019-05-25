package com.poetry.pojo.Do;

import java.util.Date;

public class PostDo {
    private Integer id;

    private String title;

    private Date postTime;

    private String posterId;

    private String content;

    private int groupId;

    private String poster;

    private String posterAvatar;

    private int ReliesNum;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getPosterId() {
        return posterId;
    }

    public void setPosterId(String posterId) {
        this.posterId = posterId == null ? null : posterId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }


    public int getReliesNum() {
        return ReliesNum;
    }

    public void setReliesNum(int reliesNum) {
        ReliesNum = reliesNum;
    }

    public String getPosterAvatar() {
        return posterAvatar;
    }

    public void setPosterAvatar(String posterAvatar) {
        this.posterAvatar = posterAvatar;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}