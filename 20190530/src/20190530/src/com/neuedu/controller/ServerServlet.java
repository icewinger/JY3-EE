package com.neuedu.controller;

import com.neuedu.pojo.User;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServerServlet",urlPatterns = "/server.do")
public class ServerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        User user = new User("张三","120346");
        User user2 = new User("张三2","120346");
        User user3 = new User("张三3","120346");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        JSONArray jsonArray = JSONArray.fromObject(users);
        resp.getWriter().write(jsonArray.toString());
    }
}
