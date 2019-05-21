package com.poetry.service;

public interface GroupUserService {
    boolean dropOutGroup(String userId,int groupId);

    boolean joinGroup(String userId,int groupId);
}
