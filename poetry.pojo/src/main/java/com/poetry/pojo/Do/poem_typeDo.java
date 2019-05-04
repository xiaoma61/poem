package com.poetry.pojo.Do;

public class poem_typeDo {
    private Integer id;

    private String poemTypeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoemTypeName() {
        return poemTypeName;
    }

    public void setPoemTypeName(String poemTypeName) {
        this.poemTypeName = poemTypeName == null ? null : poemTypeName.trim();
    }
}