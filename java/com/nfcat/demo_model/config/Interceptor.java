package com.nfcat.demo_model.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        boolean flag=false;
        if (request.getCookies()!=null){
            for(Cookie cookie:request.getCookies()){
                if (cookie.getName().equals("username")){
                    flag=true;
                }
            }
        }

        if (flag){
            return true;
        }else {
            //response.sendRedirect("/login/a");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;}
        //return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
