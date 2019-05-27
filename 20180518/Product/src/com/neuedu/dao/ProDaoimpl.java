package com.neuedu.dao;

import com.neuedu.DruidDataSource.DruidDataSource;
import com.neuedu.pojo.Product;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

    //删除数据
    @Override
    public void delOneProduct(String str) {
        Connection connection = dds.getConnection();
        String sql = "";
    }

    @Override
    public List<Product> queryAllProduct() {
        Connection connection = dds.getConnection();
        String sql = "SELECT * FROM product";
        try {
            List<Product> query = qr.query(connection, sql, new BeanListHandler<>(Product.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void changeOneProduct(Object object1, Object object2, Object object3) {

    }


    public static void main(String[] args) {
        ProDaoimpl proDaoimpl = new ProDaoimpl();
        List<Product> products = proDaoimpl.queryAllProduct();
        System.out.println(products);
    }
}

