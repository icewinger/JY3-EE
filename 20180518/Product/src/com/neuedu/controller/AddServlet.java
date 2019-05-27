package com.neuedu.controller;

import com.neuedu.dao.ProDao;
import com.neuedu.dao.ProDaoimpl;
import com.neuedu.pojo.Product;
import com.neuedu.util.FileAction;
import com.neuedu.util.ProUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "AddServlet",urlPatterns = "/add.do")
@MultipartConfig
public class AddServlet extends HttpServlet {
    private ProDao pd;

    @Override
    public void init() throws ServletException {
        pd = new ProDaoimpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String proName = request.getParameter("proName");
        String proPrice = request.getParameter("proPrice");
        Part file1 = request.getPart("file1");
        String realName = FileAction.uploadImg(file1);
        String proDes = request.getParameter("proDes");
        String proStock = request.getParameter("proStock");
        String proCateId = request.getParameter("proCateId");
        String proFac = request.getParameter("proFac");
        Product product = new Product(ProUtil.getProId(),proName,Double.parseDouble(proPrice),realName,proDes,Short.parseShort(proStock),ProUtil.getNowDate(),Short.parseShort(proCateId),proFac);
        pd.addOneProduct(product);
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
