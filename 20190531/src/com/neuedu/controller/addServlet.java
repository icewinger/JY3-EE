package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addServlet",urlPatterns = "/add.do")
public class addServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String psw = req.getParameter("psw");
        if (null!=username && null!=psw)
        {
            resp.getWriter().write("true");
        }else {
            resp.getWriter().write("false");
        }
    }
}
