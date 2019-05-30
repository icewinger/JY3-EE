package com.neuedu.controller;

import com.neuedu.dao.ProDao;
import com.neuedu.dao.ProDaoimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "changeProServlet",urlPatterns = "/change.do")
public class changeProServlet extends HttpServlet {

    private ProDao pd;

    @Override
    public void init() throws ServletException {
        pd = new ProDaoimpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String proName = request.getParameter("proName");
        String proprice = request.getParameter("proprice");
        String prodes = request.getParameter("prodes");
        String prostock = request.getParameter("prostock");
        String profactory = request.getParameter("profactory");
        pd.changeOneProduct(proName,proprice,prodes,prostock,profactory,id);
        response.sendRedirect("show02.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
