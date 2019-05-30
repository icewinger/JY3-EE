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
//增加一条商品信息
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
        String sql = "DELETE  FROM product WHERE pro_id = ?";
        try {
            qr.update(connection,sql,str);
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
//查询全部商品信息
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
//修改商品信息
    @Override
    public void changeOneProduct(Object object1, Object object2, Object object3,Object object4,Object object5,Object object6) {
        Connection connection = dds.getConnection();
        String sql = "UPDATE product SET pro_name = ?,pro_price = ?,pro_des = ?,pro_stock = ?,pro_factory = ? WHERE pro_id = ?";
        try {
            qr.update(connection,sql,object1,object2,object3,object4,object5,object6);
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
//根据关键字查询商品
    @Override
    public List<Product> queryProductByKey(String string) {
        Connection connection = dds.getConnection();
        String sql = "SELECT * FROM product WHERE pro_name LIKE ?";
        List<Product> query = null;
        try {
            query = qr.query(connection, sql, new BeanListHandler<>(Product.class), string);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return query;
    }


    public static void main(String[] args) {
        ProDaoimpl proDaoimpl = new ProDaoimpl();
        List<Product> products = proDaoimpl.queryAllProduct();
        System.out.println(products);
    }
}

