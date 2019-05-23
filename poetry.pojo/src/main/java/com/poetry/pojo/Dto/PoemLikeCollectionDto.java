package com.poetry.pojo.Dto;

import com.poetry.pojo.Do.poemDo;

import java.util.List;

/**
 * @author myl
 * @description 诗词内容页面
 * @date 2019/5/17
 */
public class PoemLikeCollectionDto {



    private List<LikeCollectionDto>types;
    private List<LikeCollectionTypeDto>typeDtos;



    public List<LikeCollectionDto> getTypes() {
        return types;
    }

    public void setTypes(List<LikeCollectionDto> types) {
        this.types = types;
    }

    private Integer id;

    private String dynasty;

    private String author;

    private String poemContent;

    private String poemAppreciation;

    private String poemTranslation;

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
        this.dynasty = dynasty == null ? null : dynasty.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPoemContent() {
        return poemContent;
    }

    public void setPoemContent(String poemContent) {
        this.poemContent = poemContent == null ? null : poemContent.trim();
    }

    public String getPoemAppreciation() {
        return poemAppreciation;
    }

    public void setPoemAppreciation(String poemAppreciation) {
        this.poemAppreciation = poemAppreciation == null ? null : poemAppreciation.trim();
    }

    public String getPoemTranslation() {
        return poemTranslation;
    }

    public void setPoemTranslation(String poemTranslation) {
        this.poemTranslation = poemTranslation == null ? null : poemTranslation.trim();
    }

    public String getPoemcol() {
        return poemcol;
    }

    public void setPoemcol(String poemcol) {
        this.poemcol = poemcol == null ? null : poemcol.trim();
    }

    public List<LikeCollectionTypeDto> getTypeDtos() {
        return typeDtos;
    }

    public void setTypeDtos(List<LikeCollectionTypeDto> typeDtos) {
        this.typeDtos = typeDtos;
    }
}
