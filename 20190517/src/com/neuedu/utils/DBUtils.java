package com.neuedu.utils;

import java.sql.*;
import java.util.Properties;

//数据库连接工具
public class DBUtils {

    private static Properties prop;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            prop = new Properties();
            prop.load(DBUtils.class.getResourceAsStream("/mysql.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String URL =prop.getProperty("url");
    private static final String USERNAME = prop.getProperty("username");
    private static final String PSW = prop.getProperty("password");

    public static Connection getConnection()
    {
        Connection conn = null;
        try {
            if (null == conn)
            {
                conn = DriverManager.getConnection(URL, USERNAME, PSW);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    //关闭Connection的方法
    public static void closeConnection(Connection conn) {
        try {
            if (null != conn) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        //关闭Preparestatement的方法
        public static void closePreparedStatement(PreparedStatement prtmt){
            try {
                if (null != prtmt) {
                    prtmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    //关闭ResultSet的方法
    public static void closeResultSet(ResultSet rs){
        try {
            if (null != rs) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
