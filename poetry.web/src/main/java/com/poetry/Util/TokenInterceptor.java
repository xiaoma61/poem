package com.poetry.Util;
import com.poetry.util.Identity;
import com.poetry.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //验证token的有效性
        try{
            String token= httpServletRequest.getParameter("token");
            Identity identity=TokenUtil.parseToken(token);
            httpServletRequest.setAttribute("id",identity.getId());
            return true;
        }catch (Exception e){
            respFail(httpServletResponse);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private void respFail(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write("登录失效，请登录");
    }


}
