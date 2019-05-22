package com.neuedu.controller;

import com.neuedu.dao.ChangPsw;
import com.neuedu.dao.ChangePswimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangePswServlet",urlPatterns = "/change.do")
public class ChangePswServlet extends HttpServlet {
    private ChangPsw cp;

    @Override
    public void init() throws ServletException {
        cp = new ChangePswimpl();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        cp.changePsw(username,password);
        response.sendRedirect("user.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
