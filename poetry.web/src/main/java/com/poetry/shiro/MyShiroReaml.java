package com.poetry.shiro;

import com.poetry.service.Impl.UserServiceImpl;
import com.poetry.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
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

        Object principal = authenticationToken.getPrincipal();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();
        String name= String.valueOf(principal);
        String pass=null;

       SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(name, pass, getName());

        return info;
    }


}
