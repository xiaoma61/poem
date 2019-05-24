package com.poetry.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.poetry.commom.AesCbcUtil;
import com.poetry.commom.UrlUtil;
import com.poetry.pojo.Do.userDo;
import com.poetry.service.WXService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WXServicelmpl implements WXService {

    //获得用户openid和session_key
    @Override
    public JSONObject getSessionKeyOrOpenId(String code) throws Exception {
        String wxCode = code;
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> requestUrlParam = new HashMap<String, String>();
        requestUrlParam.put("appid", "wx95b82b45bbdc1d6c");
        requestUrlParam.put("secret", "046214205a0f0ac5ddfcf35ecf050975");
        requestUrlParam.put("js_code", wxCode);
        requestUrlParam.put("grant_type", "authorization_code");
        String content = null;

        content = UrlUtil.sendPost(requestUrl, requestUrlParam).getContent();

        JSONObject jsonObject = JSON.parseObject(content);
        return jsonObject;

    }

    //解析用户信息
    @Override
    public userDo decodeUserInfo(String encryptedData, String session_key, String iv){
        String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
        userDo userDo=null;
        if (result != null) {
            userDo=new userDo();
            System.out.println(result);
            JSONObject userInfoJSON = JSONObject.parseObject(result);
            String name= (String) userInfoJSON.get("nickName");
            int gender= (int) userInfoJSON.get("gender");
            String avatarUrl=userInfoJSON.getString("avatarUrl");
            userDo.setUserName(name);
            userDo.setAvataPath(avatarUrl);
            if (gender==1){
                userDo.setSex("男");
            }else {
                userDo.setSex("女");
            }
        }
        return userDo;
    }

}
