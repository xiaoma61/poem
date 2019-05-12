package com.poetry.pojo.Do;

public class match_resultKey {
    private Long id;

    private String winnerId;

    private String loserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId == null ? null : winnerId.trim();
    }

    public String getLoserId() {
        return loserId;
    }

    public void setLoserId(String loserId) {
        this.loserId = loserId == null ? null : loserId.trim();
    }
}