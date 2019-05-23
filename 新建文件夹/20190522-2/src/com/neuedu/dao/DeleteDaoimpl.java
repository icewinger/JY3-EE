package com.neuedu.dao;

import com.neuedu.DruidDataSource.DruidDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteDaoimpl implements DeleteDao {
    private QueryRunner qr;

    private DruidDataSource dataSource = DruidDataSource.getDataSource();

    public DeleteDaoimpl()
    {
        qr = new QueryRunner();
    }

    @Override
    public void Delete(Integer id) {
        Connection conn = dataSource.getconnection();
        String sql = "DELETE FROM user WHERE id = ?";
        try {
            qr.update(conn,sql,id);
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
