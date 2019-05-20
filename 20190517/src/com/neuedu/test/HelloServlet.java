package com.neuedu.test;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet",urlPatterns = "/hello.do")
public class HelloServlet extends HttpServlet {

    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoimpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().write("<h1>250</h1>");
        String user = request.getParameter("username");
        String psw = request.getParameter("psw");
        boolean check = ud.check(user);
        if (check==true)
        {
            ud.regsiter(user,psw);
        //跳转到登录界面
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }else {
            //跳转到错误页面
            request.getRequestDispatcher("fail.jsp").forward(request,response);
        }

    }
}
