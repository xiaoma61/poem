package com.poetry.web.controller.indexcontroller;

import com.alibaba.fastjson.JSONObject;
import com.poetry.commom.R;
import com.poetry.shiro.MyOpenIdToken;
import com.poetry.util.Identity;
import com.poetry.util.TokenUtil;
import com.poetry.web.controller.basecontroller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("LoginController")
public class LoginController extends BaseController {

    @ResponseBody
    @RequestMapping("/login")
    public R doLogin(@RequestParam(value = "code")String code,
                     @RequestParam(value = "encryptedData") String encryptedData,
                     @RequestParam(value = "iv") String iv) throws Exception {
        JSONObject SessionKeyOpenId=wxService.getSessionKeyOrOpenId(code);
        String openid=SessionKeyOpenId.getString("openid");
        String sessionKey=SessionKeyOpenId.getString("session_key");

        if (openid!=null && sessionKey!=null){
            Subject subject= SecurityUtils.getSubject();
            MyOpenIdToken token=new MyOpenIdToken(openid+","+sessionKey+","+iv+","+encryptedData);
            try{
                subject.login(token);
                Identity identity=new Identity();
                identity.setId(openid);
                identity.setDuration((long) 604800000);
                identity.setRole("user");
                identity.setIssuer("poem");
                identity.setUserName(openid);
                String myToken=TokenUtil.createToken(identity);
                return R.ok("token",myToken);
            }catch (Exception e){
                e.printStackTrace();
                return R.error(e.toString());
            }
        }
        return R.error("未知错误，请联系管理员");
    }



}
