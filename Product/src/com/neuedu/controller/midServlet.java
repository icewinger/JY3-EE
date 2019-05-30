package com.neuedu.controller;

import com.neuedu.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "midServlet",urlPatterns = "/mid.do")
public class midServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String des = request.getParameter("des");
        String stock = request.getParameter("stock");
        String factory = request.getParameter("factory");
        System.out.println(id);
        System.out.println(name);
        System.out.println(price);
        System.out.println(des);
        System.out.println(stock);
        System.out.println(factory);
        Product product = new Product(id,name,Double.parseDouble(price),null,des,Short.parseShort(stock),null,null,factory);
        System.out.println(product);
        request.setAttribute("product",product);
        request.getRequestDispatcher("ChangePro.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
