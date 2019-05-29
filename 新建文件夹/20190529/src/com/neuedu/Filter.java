package com.neuedu;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "Filter", urlPatterns = "*.jsp")
public class Filter implements javax.servlet.Filter {
    String allFilterPage;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpServletRequest req1 = (HttpServletRequest) req;
        HttpServletResponse resp1 = (HttpServletResponse) resp;
        String requestURI = req1.getRequestURI();
        if ("/Login.jsp".equals(requestURI)) {
            chain.doFilter(req, resp);
            return;
        }


        //把要拦截的文件的民字写到配置文件里
        List<String> strings = Arrays.asList(allFilterPage.split(","));
        if (strings.contains(requestURI)) {
            Object username = ((HttpServletRequest) req).getSession().getAttribute("username");
            if (null != username) {
                chain.doFilter(req, resp);
            } else {
                ((HttpServletResponse) resp).sendRedirect("Login.jsp");

            }
        }

    }

    public void init(FilterConfig config) throws ServletException {
        allFilterPage = config.getServletContext().getInitParameter("allFliterPage");
    }

}
