package com.neuedu.Servlet;

import com.neuedu.dao.Query;
import com.neuedu.dao.Queryimpl;
import com.neuedu.user.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryServlet",urlPatterns = "/query.do")
public class QueryServlet extends HttpServlet {
    private Query qy;

    @Override
    public void init() throws ServletException {
        qy = new Queryimpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<user> query = qy.Query();
        request.setAttribute("query",query);
        request.getRequestDispatcher("Query.jsp").forward(request,response);
    }
}
