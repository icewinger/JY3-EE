package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CookieServlet",urlPatterns = "/cookie.do")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");
        String format = simpleDateFormat.format(date);
        Cookie cookie = new Cookie("time", format);
        cookie.setPath("/");
        cookie.setMaxAge(5);
        resp.addCookie(cookie);
        Cookie[] cookies = req.getCookies();

        if (null != cookies) {
            String time = null;
            for (Cookie c : cookies) {
                if ("time".equals(c.getName())) {
                    time = c.getValue();
                }
            }
            if (null != time)
            {
                resp.getWriter().write("您上次登陆时间为" + time);
            }else {
                resp.getWriter().write("欢迎您首次登陆");
            }

        }

    }
}
