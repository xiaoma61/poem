package com.poetry.service;

import com.alibaba.fastjson.JSONObject;
import com.poetry.pojo.Do.userDo;

public interface WXService {
      JSONObject getSessionKeyOrOpenId(String code) throws Exception;

     userDo decodeUserInfo(String encryptedData, String session_key, String iv) throws Exception;

}
