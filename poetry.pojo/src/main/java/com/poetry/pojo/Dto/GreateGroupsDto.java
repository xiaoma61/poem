package com.poetry.pojo.Dto;

/**
 * @author myl
 * @description 个人中心-我创建小组信息显示
 * @date 2019/5/8
 */
public class GreateGroupsDto {

    private Integer id;

    private String groupIntro;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupIntro() {
        return groupIntro;
    }

    public void setGroupIntro(String groupIntro) {
        this.groupIntro = groupIntro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
