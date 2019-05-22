package com.neuedu.utils;

import com.neuedu.user.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DBUtilsDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/20190517", "root", "123456");
            QueryRunner queryRunner = new QueryRunner();
//            String sql = "INSERT INTO user (username,psw) VALUES(?,?)";
//            int update = queryRunner.update(conn, sql, "王英坤", "250");
//            System.out.println(update);
//            String sql = "UPDATE user set psw = ? where id = ?";
//            int asaasas = queryRunner.update(conn, sql, "asaasas", 6);
//            System.out.println(asaasas);
//            String sql = "DELETE FROM user where id = ?";
//            int update = queryRunner.update(conn, sql, 4);
//            System.out.println(update);

//            String sql = "SELECT * FROM user";
//            List<User> query = queryRunner.query(conn, sql, new BeanListHandler<>(User.class));
//            System.out.println(query);
            String sql = "SELECT * FROM user WHERE id = ?";
            User query = queryRunner.query(conn, sql, new BeanHandler<>(User.class), 5);
            System.out.println(query);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
