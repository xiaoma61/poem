package com.poetry.pojo.Dto;

/**
 * @author myl
 * @description 诗词列表
 * @date 2019/5/15
 */
public class PoemDto {
    private Integer id;

    private String dynasty;

    private String author;

    private String poemContent;

    private int readNum;

    private int likeNum;

    private int readCommentNum;

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

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }


    public int getReadCommentNum() {
        return readCommentNum;
    }

    public void setReadCommentNum(int readCommentNum) {
        this.readCommentNum = readCommentNum;
    }

    public String getPoemcol() {
        return poemcol;
    }

    public void setPoemcol(String poemcol) {
        this.poemcol = poemcol;
    }
}
