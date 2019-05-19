package com.poetry.shiro;

import com.poetry.commom.RedisUtil;
import com.poetry.commom.SerializeUtil;
import com.poetry.commom.UrlUtil;
import com.poetry.pojo.Do.userDo;
import com.poetry.service.Impl.UserServiceImpl;
import com.poetry.service.UserService;
import com.poetry.service.WXService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class MyShiroReaml extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Autowired
    WXService wxService;

    /**
     * @description 实现授权
     * @author myl
     * @date 2019/5/4
     * @param principalCollection
     * @return [principalCollection]
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Object principal = principalCollection.getPrimaryPrincipal();//获取登录的用户名

        return info;
    }


    /**
     * @description 实现信息验证操作
     * @author myl
     * @date 2019/5/4
     * @param authenticationToken
     * @return [authenticationToken]
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String data=(String)authenticationToken.getPrincipal();
        String temp[]=data.split(",");
        String openId=temp[0];
        String sessionKey=temp[1];
        String iv=temp[2];
        String encryptedData=temp[3];
        userDo userDo = null;
        try {
            userDo=wxService.decodeUserInfo(encryptedData,sessionKey,iv);
            userDo.setId(openId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (RedisUtil.exists(openId)){
            //更新缓存
            RedisUtil.remove(openId);
            RedisUtil.set(openId,userDo);
        }else {
            userDo user=userService.findUserById(openId);
            if (user!=null){
                //更新数据库，并放进缓存
                userDo.setId(openId);
                userService.updateUserInfo(userDo);
                RedisUtil.set(openId, SerializeUtil.serialize(userDo));
            }else {
                //创建新用户，并放进缓存
                userDo.setGoldCoinNum(0);
                userDo.setExperienceVal(0);
                userService.insertUser(userDo);
                RedisUtil.set(openId,userDo);
            }
        }
        AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(openId,"ok",getName());
        return authenticationInfo;
    }


}
