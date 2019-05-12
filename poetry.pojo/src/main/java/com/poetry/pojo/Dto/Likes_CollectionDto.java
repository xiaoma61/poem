package com.poetry.pojo.Dto;

/**
 * @author myl
 * @description 点赞和收藏的数据
 * @date 2019/5/6
 */
public class Likes_CollectionDto {
    private Integer id;

    private Integer poemId;

    private String dynasty;

    private String author;

    private String poemcol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoemId() {
        return poemId;
    }

    public void setPoemId(Integer poemId) {
        this.poemId = poemId;
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

    public String getPoemcol() {
        return poemcol;
    }

    public void setPoemcol(String poemcol) {
        this.poemcol = poemcol;
    }
}
