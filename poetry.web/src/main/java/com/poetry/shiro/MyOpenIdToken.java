package com.poetry.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

public class MyOpenIdToken extends UsernamePasswordToken implements Serializable {

    private String openId;
    @Override
    public Object getPrincipal(){
        return openId;
    }

    @Override
    public Object getCredentials(){
        return "ok";
    }

    public MyOpenIdToken(String openId){
        this.openId=openId;
    }


}
