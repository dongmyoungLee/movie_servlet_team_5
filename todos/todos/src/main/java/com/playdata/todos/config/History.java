package com.playdata.todos.config;

import com.mysql.cj.Session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class History {
    public static void setHistory(HttpServletRequest req, HttpServletResponse resp){
        req.getCookies();
        Cookie[] cookies = req.getCookies();
        String history = "";
        for (Cookie c:cookies) {
            if(c.getName().equals("history")) history = c.getValue();
        }
        String requestURI = req.getRequestURI();
//        String servletPath = req.getServletPath();
//        String contextPath = req.getContextPath();
        history += ","+ requestURI;
        resp.addCookie(new Cookie("history", history));
//        System.out.println(requestURI+ " " + servletPath + " " + contextPath);


    }
}
