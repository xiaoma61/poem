package com.poetry.pojo.Do;

public class userDo {
    private Integer id;

    private String userName;

    private String password;

    private Integer goldCoinNum;

    private Integer experienceVal;

    private String sex;

    private String avataPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getGoldCoinNum() {
        return goldCoinNum;
    }

    public void setGoldCoinNum(Integer goldCoinNum) {
        this.goldCoinNum = goldCoinNum;
    }

    public Integer getExperienceVal() {
        return experienceVal;
    }

    public void setExperienceVal(Integer experienceVal) {
        this.experienceVal = experienceVal;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAvataPath() {
        return avataPath;
    }

    public void setAvataPath(String avataPath) {
        this.avataPath = avataPath == null ? null : avataPath.trim();
    }
}