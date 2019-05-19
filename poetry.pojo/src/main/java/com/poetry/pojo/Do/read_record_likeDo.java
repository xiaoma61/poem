package com.poetry.pojo.Do;

public class read_record_likeDo {
    private Integer id;

    private Integer readRecordId;

    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReadRecordId() {
        return readRecordId;
    }

    public void setReadRecordId(Integer readRecordId) {
        this.readRecordId = readRecordId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}