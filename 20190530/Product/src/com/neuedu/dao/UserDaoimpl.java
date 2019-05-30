package com.neuedu.dao;

import com.neuedu.DruidDataSource.DruidDataSource;
import com.neuedu.pojo.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoimpl implements UserDao {

    DruidDataSource dataSource = DruidDataSource.getDataSource();

    private QueryRunner qr;

    public UserDaoimpl()
    {
        qr = new QueryRunner();

    }    @Override
    public void addOneUser(User user) {
        Connection conn = dataSource.getConnection();
        String sql = "INSERT INTO user (username,password,date) VALUES (?,?,now())";
        try {
            qr.update(conn,sql,user.getUsername(),user.getPassword());

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean login(User user) {
        Connection connection = dataSource.getConnection();
        String sql ="SELECT username,password FROM user WHERE username = ? and password = ?";
        User query = null;
        try {
            query = qr.query(connection, sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (null != query)
            {
                return true;
            }else {
                return false;
            }
        }
    }


    @Override
    public  boolean check(String str) {
        Connection connection = dataSource.getConnection();
        String sql = "SELECT username FROM user WHERE username = ?";
        User query = null;
        try {
            query = qr.query(connection, sql, new BeanHandler<>(User.class), str);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {e.printStackTrace();

            }
        }
        if (null == query)
        {
            return true;
        }else {
            return false;
        }
    }
}
