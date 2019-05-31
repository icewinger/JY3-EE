package com.neuedu.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class Session implements HttpSessionListener {
    public Session(){

    }
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session创建");
        HttpSession session = httpSessionEvent.getSession();
//        session.getMaxInactiveInterval(10);
//        session.invalidate();

//        System.out.println(maxInactiveInterval);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
