package com.neuedu.Servlet;

import com.neuedu.dao.Changeimpl;
import com.neuedu.dao.Changepsw;
import com.neuedu.dao.Loginimpl;
import com.neuedu.user.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangepswServlet",urlPatterns = "/change.do")
public class ChangepswServlet extends HttpServlet {

    private Changepsw cp;

    @Override
    public void init() throws ServletException {
        cp = new Changeimpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String psw = request.getParameter("psw");
        String psw2 = request.getParameter("psw2");
        user user1 = new user(username,psw);
        Loginimpl loginimpl = new Loginimpl();
        boolean login = loginimpl.Login(user1);
        if (login == true)
        {
                cp.Changepsw(username,psw2);
                request.getRequestDispatcher("Change.jsp").forward(request,response);
        }else {
               request.getRequestDispatcher("ChangePassword.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
