package com.neuedu.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public Listener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application创建");
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("username","wangyingkun");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application销毁");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
//        System.out.println("session创建");
//        HttpSession session = se.getSession();
//        int maxInactiveInterval = session.getMaxInactiveInterval();
//          session.invalidate();
//
//        System.out.println(maxInactiveInterval);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session销毁");
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
