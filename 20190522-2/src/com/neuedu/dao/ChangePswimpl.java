package com.neuedu.dao;

import com.neuedu.DruidDataSource.DruidDataSource;
import com.neuedu.user.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class ChangePswimpl implements ChangPsw {

    private QueryRunner qr;

    private DruidDataSource dataSource = DruidDataSource.getDataSource();

    public ChangePswimpl()
    {
        qr = new QueryRunner();
    }
    @Override
    public void changePsw(String username, String psw) {
        Connection conn = dataSource.getconnection();
        String sql = "UPDATE USER \n" +
                "SET psw = ?\n" +
                "WHERE username = ?";
        try {
            qr.update(conn,sql,psw,username);
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
}
