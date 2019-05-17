package com.poetry.pojo.Dto;

/**
 * @author myl
 * @description签到诗词
 * @date 2019/5/14
 */
public class PeopleRegisterDto {
    private Integer id;

    private String dynasty;

    private String author;

    private String poemContent;

    private String poemcol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPoemContent() {
        return poemContent;
    }

    public void setPoemContent(String poemContent) {
        this.poemContent = poemContent;
    }

    public String getPoemcol() {
        return poemcol;
    }

    public void setPoemcol(String poemcol) {
        this.poemcol = poemcol;
    }
}
