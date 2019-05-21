package com.neuedu.Servlet;

import com.neuedu.dao.Login;
import com.neuedu.dao.Loginimpl;
import com.neuedu.user.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/Login.do")
public class LoginServlet extends HttpServlet {
    private Login login;

    @Override
    public void init() throws ServletException {
        login = new Loginimpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String psw = req.getParameter("psw");
        user user1 = new user(user,psw);
        boolean login = this.login.Login(user1);
        if (login==true)
        {
            req.getRequestDispatcher("Login2.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("fail.jsp").forward(req,resp);

        }
    }
}
