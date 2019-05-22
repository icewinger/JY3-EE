package com.neuedu.dao;


import com.neuedu.DruidDataSource.DruidDataSource;
import com.neuedu.user.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoimpl implements UserDao {
    private QueryRunner qr;

    private DruidDataSource dataSource = DruidDataSource.getDataSource();

    public UserDaoimpl()
    {
        //构造器初始化QueryRuner对象
        qr = new QueryRunner();
    }

    @Override
    public List<User> getAllUser() {
        Connection conn = dataSource.getconnection();
        List<User> query = null;
        String sql = "SELECT * FROM user";
        try {
            query = qr.query(conn, sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return query;
    }
}
