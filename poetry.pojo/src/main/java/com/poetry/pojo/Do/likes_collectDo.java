package com.poetry.pojo.Do;

public class likes_collectDo {
    private Integer id;

    private String type;

    private Integer ueserId;

    private Integer poemId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getUeserId() {
        return ueserId;
    }

    public void setUeserId(Integer ueserId) {
        this.ueserId = ueserId;
    }

    public Integer getPoemId() {
        return poemId;
    }

    public void setPoemId(Integer poemId) {
        this.poemId = poemId;
    }
}