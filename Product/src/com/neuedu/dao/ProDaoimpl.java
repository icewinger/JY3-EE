package com.neuedu.dao;

import com.neuedu.DruidDataSource.DruidDataSource;
import com.neuedu.pojo.Product;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class ProDaoimpl implements ProDao {

    private DruidDataSource dds;

    private QueryRunner qr;

    public ProDaoimpl()
    {
        this.dds = DruidDataSource.getDataSource();
        qr = new QueryRunner();
    }

    @Override
    public void addOneProduct(Product product) {
        Connection connection = dds.getConnection();
        String sql = "INSERT INTO product VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            qr.update(connection,sql,product.getPro_id(),product.getPro_name(),product.getPro_price(),product.getPro_image(),product.getPro_des(),product.getPro_stock(),product.getPro_date(),product.getPro_category_id(),product.getPro_factory());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
