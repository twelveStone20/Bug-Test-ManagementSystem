package com.example.demo.filter;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Result;
import com.example.demo.utils.JwtUtils;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter{
    
    @Override
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse resp=(HttpServletResponse) response;

        String url=req.getRequestURL().toString();

        if(url.contains("login")){
            chain.doFilter(request, response);
            return;
        }

        String jwt=req.getHeader("Authorization");

        if(!StringUtils.hasLength(jwt)){
            Result error=Result.error("NOT_LOGIN");
            String notLogin=JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        try{
            JwtUtils.parseJwt(jwt);
        }catch(Exception e){
            Result error=Result.error("NOT_LOGIN");
            String notLogin=JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        
        chain.doFilter(request, response);
    }
}
