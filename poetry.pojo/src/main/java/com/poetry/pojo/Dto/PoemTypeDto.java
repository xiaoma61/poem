package com.poetry.pojo.Dto;

import java.util.List;

/**
 * @author myl
 * @description 诗词类型查询的
 * @date 2019/5/17
 */
public class PoemTypeDto {


    private List<PoemDto> poemDto;

    private String poemTypeName;

    private int poemTypeId;

    public List<PoemDto> getPoemDto() {
        return poemDto;
    }

    public void setPoemDto(List<PoemDto> poemDto) {
        this.poemDto = poemDto;
    }

    public String getPoemTypeName() {
        return poemTypeName;
    }

    public void setPoemTypeName(String poemTypeName) {
        this.poemTypeName = poemTypeName;
    }

    public int getPoemTypeId() {
        return poemTypeId;
    }

    public void setPoemTypeId(int poemTypeId) {
        this.poemTypeId = poemTypeId;
    }
}
