package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session1 = request.getSession();
        String username = request.getParameter("username");
        String psw = request.getParameter("psw");
        Cookie cookie = new Cookie("JSESSIONID",session1.getId());
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        if (null!=username && username.length()>0 && null != psw && psw.length() > 0)
        {
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            response.sendRedirect("index.jsp");
        }else
        {
            response.sendRedirect("Login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
