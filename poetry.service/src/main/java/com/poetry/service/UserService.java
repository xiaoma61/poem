package com.poetry.service;

import com.poetry.pojo.Do.userDo;

public interface UserService {

    public userDo findUserById(String id);

    public boolean insertUser(userDo user);

    boolean updateUserInfo(userDo userDo);

}
